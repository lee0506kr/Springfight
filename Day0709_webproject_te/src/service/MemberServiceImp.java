package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import commons.Constants;
import dao.BoardDao;
import dao.MemberDao;



@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDao memberDao;
	


	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		Map<String, Object> member;
		
		member = memberDao.selectOne(id);

		if (member != null) {
			// 아이디 있음
			if (member.get(Constants.Member.PW).equals(pw)) {
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
	public List<Map<String , Object>> selectAll() {
		return memberDao.selectAll();

	}

	@Override
	public Map<String , Object> getMemberById(String id){
	
		return memberDao.selectOne(id);
	}

	@Transactional
	@Override
	public boolean join(Map<String, Object> member) {
	
		
		int result = memberDao.insertMember(member);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
}
