package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import model.Member;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub

		Member member = memberDao.selectOne(id);

		if (member != null) {
			// 아이디 있음
			if (member.getPw().equals(pw)) {
				return true;
			} else {
				return false;
			}
		} else {
			// 아이디 없음 : 로그인 실패
			return false;
		}
	}

	@Override
	public List<Member> selectAll() {
		return memberDao.selectAll();

	}

	@Override
	public Member getMemberById(String id) {
	
		return memberDao.selectOne(id);
	}

	@Override
	public boolean join(Member member) {
		int rowCount = memberDao.insertMember(member);
		if(rowCount >0) {
			return true;
		}else {
			return false;
		}
	}
}
