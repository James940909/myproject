package test;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sun.org.apache.bcel.internal.generic.NEW;

//���, �ֳ����̼�
@WebListener
public class InitialMember implements ServletContextListener{ // �������� �ο��Ǽ� �������̵�!!

	@Override
	public void contextDestroyed(ServletContextEvent arg0) { // ����κ�
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) { // ���ۺκ�
		//���⼭ DB�����͸� ������ ����.
		// >> ������ Member.java�� ��ü�Ѵ�.
		
		ArrayList<Member> datas=new ArrayList<Member>();
			
		for(int i=0;i<5;i++) {
			Member data=new Member("Ƽ��"+i, "timo"+i+"@naver.com");
			datas.add(data);
		}
		
		datas.add(new Member("�Ƹ�",null));
		datas.add(new Member("�ƹ���",null));
		
		
		//���� ���� �����͵��� ��Ĺ�� ���۵ɶ� ������ ���̴�.
		//scope�� application�� �����ϰ� �ʹ�!
		
		//�����ǵ� �޼ҵ忡�� ���ڰ� �ִµ�
		ServletContext context= arg0.getServletContext();
		// ���� ���� application �������� ����ȴ� 
		context.setAttribute("members", datas);
		context.setAttribute("member", new Member());
		
	}
	
	

}
