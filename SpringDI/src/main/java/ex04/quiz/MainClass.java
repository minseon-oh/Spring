package ex04.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//car,airplane빈을 생성하고, 의존성주입
		//각 객체안에있는 배터리를 자바클래스에서출력
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application_context.xml");
		Car car = ctx.getBean(Car.class);
		car.getBattery().energy();
		
		Airplane a = ctx.getBean(Airplane.class);
		a.getBattery().energy();
		
	}

}
