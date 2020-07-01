package ex08.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex01.SpringTest;
import ex02.construct.Chef;
import ex02.construct.Hotel;
import ex03.setter.*;
import ex04.quiz.Airplane;
import ex04.quiz.Battery1;

import ex04.quiz.Battery2;
import ex04.quiz.Car;

//이 클래스가 스프링 설정 파일이라는 것을 표기합니다. (XML을 대신할 수 있음)
@Configuration
public class JavaConfig {

	
	// Bean이 붙은 메서드를 스프링컨네이너가 bean처럼 사용합니다.
	
	//<bean id = "test" class = "ex01.SpringTest" />
	@Bean
	public SpringTest test() {
		return new SpringTest();
	}
	
	//<bean id = "chef" class = "ex02.construct.Chef"/>
	@Bean
	public Chef chef() {
		return new Chef();
	}
	
	//<bean id = "hotel" class = "ex02.construct.Hotel" />
	@Bean
	public Hotel hotel() {
		Hotel hotel = new Hotel(chef());
		return hotel;
	}

	//세터주입
	//<bean id = "dbDev" class = "ex03.setter.DatabaseDev"/>
	@Bean
	public DataBaseDev dbDev() {
		
		DataBaseDev dev = new DataBaseDev();
		dev.setUrl("마이에스큐엘");
		dev.setUid("kkk123");
		dev.setUpw("1234");
		
		return dev;
	}
	//세터주입(객체)
	//<bean id = "memberDAO" class = "ex03.setter.MemberDAO"/>
	@Bean
	public MemberDAO MemberDAO () {
		
		MemberDAO dao = new MemberDAO();
		dao.setDatasource( dbDev() );
		return dao;
	}
	
	//퀴즈4
	//<bean id = "battery1" class = "ex04.quiz.Battery1"/>
	@Bean
	public Battery1 battery1() {
		return new Battery1();
	}
	
	//<bean id = "battery2" class = "ex04.quiz.Battery2"/>
	@Bean
	public Battery2 battery2() {
		return new Battery2();
	}
	
	//<bean id = "car" class = "ex04.quiz.Car"/>
	@Bean
	public Car car() {
		Car car = new Car(battery1());
		return car;
	}
	
	//<<bean id = "airplane" class = "ex04.quiz.Airplane">
		@Bean
		public Airplane airplane() {
			Airplane airplane = new Airplane();
			return airplane;
		}
	

}