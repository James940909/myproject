package test;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sun.org.apache.bcel.internal.generic.NEW;

//어노, 애노테이션
@WebListener
public class InitialMember implements ServletContextListener{ // 강제성이 부여되서 오버라이딩!!

	@Override
	public void contextDestroyed(ServletContextEvent arg0) { // 종료부분
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) { // 시작부분
		//여기서 DB데이터를 생성할 예정.
		// >> 현재의 Member.java로 대체한다.
		
		ArrayList<Member> datas=new ArrayList<Member>();
			
		for(int i=0;i<5;i++) {
			Member data=new Member("티모"+i, "timo"+i+"@naver.com");
			datas.add(data);
		}
		
		datas.add(new Member("아리",null));
		datas.add(new Member("아무무",null));
		
		
		//현재 만든 데이터들은 톰캣이 시작될때 생성될 것이다.
		//scope는 application에 저장하고 싶다!
		
		//재정의된 메소드에는 인자가 있는데
		ServletContext context= arg0.getServletContext();
		// 이제 전부 application 스코프에 저장된다 
		context.setAttribute("members", datas);
		context.setAttribute("member", new Member());
		
	}
	
	

}
