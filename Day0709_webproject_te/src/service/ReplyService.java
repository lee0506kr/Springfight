package service;

import java.util.List;

import model.Reply;

public interface ReplyService {
	public boolean addReply(Reply reply);
	public List<Reply> getBoardReply(int boardNum);
	public boolean removeReply(int replyNum);
	public boolean modifyReply(Reply reply);
}
