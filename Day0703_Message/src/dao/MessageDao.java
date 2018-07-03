package dao;

import java.util.List;
import java.util.Map;

import model.Message;

public interface MessageDao {
	public int insertMessage(Message message);
	public int deleteMessage(int id);
	public Message selectOne(int id);
	public List<Message> selectAll();
	
	public int selectCount();
	
	public List<Message> selectList(Map<String, Object> params);
	
}
