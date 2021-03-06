package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import dao.MessageDao;
import model.Message;

@Service
public class MessageServiceImp implements MessageService {

	@Autowired
	private MessageDao dao;
	
	//한페이지에 표시될 메시지의 개수
	private static final int NUM_OF_MESSAGE_PER_PAGE = 10;
	//한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 10;
	

	@Override
	public List<Map<String, Object>> getAllMessages() {

		return dao.selectAll();
	}

	@Override
	public boolean writeMessage(Message message) {

		Message m = new Message();
		m.setName(m.getName());
		m.setPassword(m.getPassword());
		m.setMessage(m.getMessage());
		int result = dao.insertMessage(m);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteMessage(int id, String password) {
		Message message = dao.selectOne(id);

		if (message != null && message.getPassword().equals(password)) {
			dao.deleteMessage(id);
			return true;
		}
		return false;
	}

	@Override
	public Map<String, Object> getMessageList(int pageNumber) {

		Map<String, Object> viewData = new HashMap<String, Object>();
		
		int firstRow = 0;
		int endRow = 0;
		int totalCount = 0;
		
		totalCount = dao.selectCount();
		
		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE +1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		//List<Message> selectList(int,int)
		
		List<Map<String, Object>> messageList 
		  = dao.selectList(firstRow, endRow);
		viewData.put("currentPage",pageNumber);
		viewData.put("messageList", messageList);
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

}
