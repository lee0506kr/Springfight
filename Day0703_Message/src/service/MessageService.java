package service;

import java.util.List;
import java.util.Map;

import model.Message;

public interface MessageService {

	

	public boolean writeMessage(Message message);

	public boolean deleteMessage(int id, String password);

	public Map<String, Object> getMessageList(int pageNumber);

	public int calPageTotalCount(int totalCount);

	public int getStartPage(int pageNum);

	public int getEndPage(int pageNum);

	public List<Message> getAllMessages();

}
