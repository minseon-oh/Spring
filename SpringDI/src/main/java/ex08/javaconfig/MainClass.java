package ex08.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex01.SpringTest;
import ex03.setter.DataBaseDev;
import ex04.quiz.Airplane;
import ex04.quiz.Car;

public class MainClass {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		SpringTest st = ctx.getBean(SpringTest.class);
		
		st.test();
		
		DataBaseDev dev = ctx.getBean(DataBaseDev.class);
		System.out.println("URL : " + dev.getUrl());
		System.out.println("UID : " + dev.getUid());
		System.out.println("UPW : " + dev.getUpw());
		
		Car car = ctx.getBean(Car.class);
		car.getBattery().energy();
		
		Airplane air = ctx.getBean(Airplane.class);
		air.getBattery().energy();
	}
}