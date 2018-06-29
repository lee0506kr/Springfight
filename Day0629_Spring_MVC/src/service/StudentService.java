package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	
	
	public List<Map<String, Object>> selectStudentsByGrade(int grade){
		
		return dao.selectStudentsByGrade(grade);
	}

	
	public boolean addStudent(String name, int grade) {
		//파라미터로 넘어온 데이터를 Map으로 만들고 dao의 인자로 넘겨준다. 
		Map<String, Object> param = new HashMap<String,Object>();
		
		param.put("name", name);
		param.put("grade", grade);
		int result = dao.insertStudent(param);
		//insert 후에, 자동으로 생성된 num을 어떻게 가져오나?
		
		
		
		if(result > 0 ) {
			return true;
		}else {
			return false;
		}
		
	}

}
