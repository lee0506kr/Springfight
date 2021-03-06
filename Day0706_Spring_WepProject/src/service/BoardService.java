package service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	
	public boolean writeBoard(Map<String, Object> board);


	public Map<String, Object> getBoardList(int num);

	public int calPageTotalCount(int totalCount);

	public int getStartPage(int pageNum);

	public int getEndPage(int pageNum);

	public List<Map<String, Object>> getAllBoard();


	
	public Map<String, Object> getOneBoard(int num);


	public boolean deleteBoard(int num);
	
	
	public boolean modifyBoard(Map<String,Object> board);
	
	
	
	
	
	
	
}
