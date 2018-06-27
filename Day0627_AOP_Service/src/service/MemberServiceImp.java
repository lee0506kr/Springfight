package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.MemberDao;
import model.Member;

@Component
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public List<Member> getAllMember() {
		
		return memberDao.selectAll();
	}
	
}
