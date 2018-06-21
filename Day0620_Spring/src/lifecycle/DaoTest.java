package lifecycle;

import javax.swing.AbstractAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		//스프링컨테이너 로딩
		//스프링 컨테이너에서 Dao 객체 꺼내와서 사용해보기 
		//Dao 스프링 컨테이너에 등록하고 사용해보기 
		//1. ConnectionProvider, StudentDao
		//객체 bean으로 등록하기
		//2. ConnectionProvider 객체를 
		// StudentDao에 의존성 주입하기 (setter든, 생성자든 아무거나)
		
		ApplicationContext context 
		 = new GenericXmlApplicationContext("lifecycle/applicationContext.xml");
		
		
		System.out.println("컨테이너 준비완료");
		StudentDao dao1 = context.getBean("studentDao",StudentDao.class);
		
		//StudentDao dao2 = context.getBean("studentDao",StudentDao.class);
		
		System.out.println("bean 객체 반환");
		
		//spring container에서 기본 설정은 singleton
		
		
	/*	if(dao1 == dao2) {
			System.out.println("같은 객체입니다.");
		}else {
			System.out.println("다른 객체");
		}
		*/
		
		//컨테이너 닫아주는 메서드, 실제로는 안씁니다.
		((AbstractApplicationContext)context).close();
		
		
		
		
		
		
		/*
		Student student = new Student();
		
//		student.setSnum(1);
//		student.setSname("홍길동");
//		student.setSgrade(3);
		
//		dao.insertStudent(student);
		System.out.println(dao.selectOne(1));
		*/
		
		
		
	}
}
