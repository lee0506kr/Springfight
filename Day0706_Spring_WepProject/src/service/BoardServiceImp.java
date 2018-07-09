package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;


@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao dao;

	// 한페이지에 표시될 메시지의 개수
	private static final int NUM_OF_MESSAGE_PER_PAGE = 5;
	// 한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 5;

	@Override
	public boolean writeBoard(Map<String, Object> board) {

		int result = dao.insertBoard(board);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteBoard(int num) {

		int result = dao.deleteBoard(num);
		
		if (result  > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Map<String, Object>> getAllBoard() {

		return dao.selectAll();
	}

	@Override
	public Map<String, Object> getBoardList(int pageNumber) {
		
		Map<String, Object> viewData = new HashMap<String, Object>();
		
		
		int firstRow = 0;
		int endRow = 0;
		int totalCount = 0;
		
		totalCount = dao.selectCount();

		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE +1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		//List<Message> selectList(int,int)
		Map<String, Object> row = new HashMap<String, Object>();
		row.put("firstRow", firstRow);
		row.put("endRow", endRow);
		
		List<Map<String, Object>> boardList 
		  = dao.selectList(row);
		
		
		
		
		viewData.put("currentPage",pageNumber);
		viewData.put("boardList", boardList);
		viewData.put("pageTotalCount",calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNumber));
		viewData.put("endPage", getEndPage(pageNumber));
		//필요한 데이터 : 총 페이지의 개수, 총 메시지의 개수
		//시작 페이지,종료페이지
		
		return viewData;
		
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
	public Map<String, Object> getOneBoard(int num) {
		
		dao.updateReadCount(num);
		
		System.out.println(dao.selectOne(num));
		
		return dao.selectOne(num);
	}

	@Override
	public boolean modifyBoard(Map<String, Object> board) {
	
		int result = dao.updateBoard(board);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	

}
