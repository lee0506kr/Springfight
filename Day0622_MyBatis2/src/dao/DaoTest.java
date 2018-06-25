package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import common.Constant;

public class DaoTest {
	public static void main(String[] args) {
		MessageDao dao = new MessageDao();

		Map<String, Object> message = dao.selectOne(49);

		

		// while(it.hasNext()) {
		// System.out.println("key : " + it.next());
		// }

		// for(Map<String,Object> m: dao.selectAll()) {
		// System.out.println("아이디 : " + m.get(Constant.Message.ID));
		// System.out.println("메시지 : " + m.get(Constant.Message.MESSAGE));
		// System.out.println("비번 : " + m.get(Constant.Message.PASSWORD));
		// System.out.println("이름 : " + m.get(Constant.Message.NAME));
		// }
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Constant.Message.NAME, "장길산");
		param.put(Constant.Message.ID, "qwewqew");
		param.put(Constant.Message.PASSWORD, "123");
		param.put(Constant.Message.MESSAGE, "즐거운");

		dao.insertMessage(param);

	}
}
