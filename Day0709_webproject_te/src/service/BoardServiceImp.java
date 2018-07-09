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
	
	//파일 저장 경로
	private static final String UPLOAD_PATH="C:\\temp";
	
	@Autowired
	BoardDao boardDao;
	
	private static final int NUM_OF_MESSAGE_PER_PAGE = 5;
	// 한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 5;
	
	@Override
	public List<Map<String, Object>> boardList() {
		return boardDao.selectAll();
	}

	@Override
	public List<Map<String, Object>> getBoardList(Map<String, Object> param, int page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> readBoard(int num) {
		// TODO Auto-generated method stub
		//해당 게시글의 조회수를 1증가 시키고, 해당 게시글 가져오기
		Map<String, Object> board = boardDao.selectOne(num);
		//게시글 조회수 증가 시키기 
		int readCount; 
		BigDecimal bigDecimal = (BigDecimal)board.get(Constants.Board.READ_COUNT);
		readCount = bigDecimal.intValueExact();
//		System.out.println("readCount : " + readCount);
		board.put(Constants.Board.READ_COUNT,readCount+1);
		boardDao.updateBoard(board);
		return board;
	}
	@Override
	public Map<String, Object> getBoard(int num) {
		return boardDao.selectOne(num);
	}
	@Override
	public boolean writeBoard(Map<String, Object> board, MultipartFile file) {
		try{
			boardDao.insertBoard(board);
			//파일을 로컬에 저장하고, 파일 이름은, attach table에 insert 
			//board num과 file의 이름을 attach table에 insert
			String fullName = writeFile(file);
			//FULLNAME,NUM
			Map<String, Object> params = new HashMap<String,Object>();
			params.put(Constants.Attach.FULL_NAME, fullName);
			params.put(Constants.Attach.NUM, board.get(Constants.Board.NUM));
			boardDao.insertAttach(params);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean modifyBoard(Map<String, Object> board) {
		if(boardDao.updateBoard(board) >0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean removeBoard(int num) {
		if(boardDao.deleteBoard(num)>0) {
			return true;
		}
		return false;
	}
	
	//수정, 삭제시 비밀번호 확인
	@Override
	public boolean checkPass(Map<String, Object> param) {
		//param 게시글 번호, 비밀번호 가 포함되어 있음
		System.out.println("service checkPass : " + param);
		int num  = Integer.parseInt((String)param.get(Constants.Board.NUM));
//		String num  = (String)param.get(Constants.Board.NUM);
		
		String pass = (String)param.get(Constants.Board.PASS);
		//num을 이용해서 원래 정보 읽어옴
		Map<String, Object> board = boardDao.selectOne(num);
		//원래 비밀번호 가져옴
		String originPass = (String)board.get(Constants.Board.PASS);
		//원래 비밀번호와 입력받은 비밀번호 비교 
		if(originPass.equals(pass)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public File getAttachFile(int num) {
		//게시글에 포함된 첨부파일 가져오기 
		//게시글 번호를 이용해서 file fullName 얻어오고,
		//fullName을 이용해서 파일 얻어오기 
		//attach table에서 파일이름 얻어오기 
		Map<String, Object> board = boardDao.selectOne(num);
		String fullName = (String)board.get(Attach.FULL_NAME);
		return new File(UPLOAD_PATH,fullName);
	}

	@Override
	public String writeFile(MultipartFile file) {
		//파일 저장하고 uuid 붙여서 이름 만들어 내고, 이름 반환
		String fullName = null;
		//파일이름 만들어내고,
		UUID uuid  = UUID.randomUUID();
		fullName = uuid.toString()+"_"+file.getOriginalFilename();
		//파일 생성하고,
		File target = new File(UPLOAD_PATH,fullName);
		try {
			//원래파일을 만들어낸 파일에 복사
			FileCopyUtils.copy(file.getBytes(), target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//만들어낸 파일이름 반환
		return fullName;
	}


	@Override
	public int calPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if(totalCount != 0) {
			pageTotalCount = (int)Math.ceil(
					((double)totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}

	@Override
	public int getStartPage(int pageNum) {
		int startPage = 
				((pageNum-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE + 1;
		
		return startPage;
	}

	@Override
	public int getEndPage(int pageNum) {
		int endPage 
		= (((pageNum-1)/NUM_OF_NAVI_PAGE)+1)
		* NUM_OF_NAVI_PAGE;
		return endPage;
	}

	@Override
	public Map<String, Object> getBoardList(int pageNumber) {
		
		Map<String, Object> viewData = new HashMap<String, Object>();
		
		
		int firstRow = 0;
		int endRow = 0;
		int totalCount = 0;
		
		totalCount = boardDao.selectCount();

		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE +1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		//List<Message> selectList(int,int)
		Map<String, Object> row = new HashMap<String, Object>();
		row.put("firstRow", firstRow);
		row.put("endRow", endRow);
		
		List<Map<String, Object>> boardList 
		  = boardDao.selectList(row);
		
		
		
		
		viewData.put("currentPage",pageNumber);
		viewData.put("boardList", boardList);
		viewData.put("pageTotalCount",calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNumber));
		viewData.put("endPage", getEndPage(pageNumber));
		//필요한 데이터 : 총 페이지의 개수, 총 메시지의 개수
		//시작 페이지,종료페이지
		
		return viewData;
		
	}

	
}
