package service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import commons.Constants;
import commons.Constants.Attach;
import dao.BoardDao;

@Service
public class BoardServiceImp implements BoardService {

	// 파일 저장 경로
	private static final String UPLOAD_PATH = "C:\\temp";

	private static final int NUM_OF_BOARD_PER_PAGE = 5;
	// 한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 5;

	@Autowired
	BoardDao boardDao;

	@Override
	public List<Map<String, Object>> boardList() {
		return boardDao.selectAll();
	}

	@Override
	public Map<String, Object> getBoardList(Map<String, Object> param, int page) {
		// param 에 검색어와 검색 타입이 들어있음
		// 검색 게시글 조회하기
		// 페이징 처리 포함
		List<Map<String, Object>> boardList;
		// 현재게시글의 총 개수를 넣어주기
		 int pageTotalCount;
		/* 화면 출력에 필요한 값 */
		int startPage = getStartPage(page);
		int endPage = getEndPage(page);

		/* 데이터 조회에 필요한 값 */
		int firstRow = getFirstRow(page);
		int endRow = getEndRow(page);

		param.put("firstRow", firstRow);
		param.put("endRow", endRow);

		int type = (int) param.get("type");
		String keyword = (String) param.get("keyword");

		/*
		 * type == 1 제목검색 
		 * type == 2 작성자 
		 * type == 3 제목+작성자 
		 * type == 4 내용검색 
		 * type == 0 검색x,전체조회
		 */
		if (type == 1) {
			param.put("TITLE", keyword);
		} else if (type == 2) {
			param.put("NAME", keyword);
		} else if (type == 3) {
			param.put("TITLE", keyword);
			param.put("NAME", keyword);
		} else if (type == 4) {
			param.put("CONTENT", keyword);
		} 
		
		pageTotalCount = getPageTotalCount(boardDao.totalBoardCount(param));
		
		boardList = boardDao.searchBoard(param);
		
		/**** 결과값 Map에 넣어서 반환하기 ****/
		/*화면에서 쓸 데이터 */
		Map<String, Object> result = new HashMap<String,Object>();
		
		result.put("boardList",boardList);
		result.put("startPage", startPage);
		result.put("endPage", endPage);
		result.put("currentPage", page);
		result.put("pageTotalCount", pageTotalCount);
		
		
		
		return result;
	}

	@Override
	public Map<String, Object> readBoard(int num) {
		// TODO Auto-generated method stub
		// 해당 게시글의 조회수를 1증가 시키고, 해당 게시글 가져오기
		Map<String, Object> board = boardDao.selectOne(num);
		// 게시글 조회수 증가 시키기
		int readCount;
		BigDecimal bigDecimal = (BigDecimal) board.get(Constants.Board.READ_COUNT);
		readCount = bigDecimal.intValueExact();
		// System.out.println("readCount : " + readCount);
		board.put(Constants.Board.READ_COUNT, readCount + 1);
		boardDao.updateBoard(board);
		return board;
	}

	@Override
	public Map<String, Object> getBoard(int num) {
		return boardDao.selectOne(num);
	}

	@Override
	public boolean writeBoard(Map<String, Object> board, MultipartFile file) {
		try {
			boardDao.insertBoard(board);
			// 파일을 로컬에 저장하고, 파일 이름은, attach table에 insert
			// board num과 file의 이름을 attach table에 insert
			String fullName = writeFile(file);
			// FULLNAME,NUM
			Map<String, Object> params = new HashMap<String, Object>();
			params.put(Constants.Attach.FULL_NAME, fullName);
			params.put(Constants.Attach.NUM, board.get(Constants.Board.NUM));
			boardDao.insertAttach(params);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modifyBoard(Map<String, Object> board) {
		if (boardDao.updateBoard(board) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeBoard(int num) {
		if (boardDao.deleteBoard(num) > 0) {
			return true;
		}
		return false;
	}

	// 수정, 삭제시 비밀번호 확인
	@Override
	public boolean checkPass(Map<String, Object> param) {
		// param 게시글 번호, 비밀번호 가 포함되어 있음
		System.out.println("service checkPass : " + param);
		int num = Integer.parseInt((String) param.get(Constants.Board.NUM));
		// String num = (String)param.get(Constants.Board.NUM);

		String pass = (String) param.get(Constants.Board.PASS);
		// num을 이용해서 원래 정보 읽어옴
		Map<String, Object> board = boardDao.selectOne(num);
		// 원래 비밀번호 가져옴
		String originPass = (String) board.get(Constants.Board.PASS);
		// 원래 비밀번호와 입력받은 비밀번호 비교
		if (originPass.equals(pass)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public File getAttachFile(int num) {
		// 게시글에 포함된 첨부파일 가져오기
		// 게시글 번호를 이용해서 file fullName 얻어오고,
		// fullName을 이용해서 파일 얻어오기
		// attach table에서 파일이름 얻어오기
		Map<String, Object> board = boardDao.selectOne(num);
		String fullName = (String) board.get(Attach.FULL_NAME);
		return new File(UPLOAD_PATH, fullName);
	}

	@Override
	public String writeFile(MultipartFile file) {
		// 파일 저장하고 uuid 붙여서 이름 만들어 내고, 이름 반환
		String fullName = null;
		// 파일이름 만들어내고,
		UUID uuid = UUID.randomUUID();
		fullName = uuid.toString() + "_" + file.getOriginalFilename();
		// 파일 생성하고,
		File target = new File(UPLOAD_PATH, fullName);
		try {
			// 원래파일을 만들어낸 파일에 복사
			FileCopyUtils.copy(file.getBytes(), target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 만들어낸 파일이름 반환
		return fullName;
	}

	private int getPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if (totalCount != 0) {
			pageTotalCount = (int) Math.ceil(((double) totalCount / NUM_OF_BOARD_PER_PAGE));
		}
		return pageTotalCount;
	}

	private int getStartPage(int currentPage) {
		return ((currentPage - 1) / NUM_OF_NAVI_PAGE) * NUM_OF_NAVI_PAGE + 1;
	}

	private int getEndPage(int currentPage) {
		return (((currentPage - 1) / NUM_OF_NAVI_PAGE) + 1) * NUM_OF_NAVI_PAGE;
	}

	private int getFirstRow(int currentPage) {
		return (currentPage - 1) * NUM_OF_BOARD_PER_PAGE + 1;
	}

	private int getEndRow(int currentPage) {
		return currentPage * NUM_OF_BOARD_PER_PAGE;
	}

}
