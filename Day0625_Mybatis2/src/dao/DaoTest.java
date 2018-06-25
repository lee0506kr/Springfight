package dao;

import java.util.HashMap;
import java.util.Map;

public class DaoTest {
	public static void main(String[] args) {
StudentDao dao = new StudentDaoImp();
		
		Map<String, Object> params
		 = new HashMap<String,Object>();
		params.put("SNUM", 123);
		params.put("SNAME", "장길산11");
		params.put("SGRADE", 3);
		
		dao.updateStudent(params);
		System.out.println("종료");
		
	}

}
