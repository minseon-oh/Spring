package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		SpringTest s = new SpringTest();
//		s.test();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application_context.xml");
		SpringTest s1 = ctx.getBean(SpringTest.class);
		s1.test();
		SpringTest s2 = ctx.getBean(SpringTest.class);
		s2.test();
		
		//스프링 IOC컨테이는 기본적으로 bean을 싱글톤 형식으로 생성한다
		//만약, bean 을 사용할 때 마다 새로운 객체형태로 쓰고싶다면 scope="prototype" 기술하면 됩니다.
		System.out.println(s1);
		System.out.println(s2);
	}

}
