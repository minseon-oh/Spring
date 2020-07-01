package ex07.quiz;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {

	@Autowired
	private Mouse mouse;
	@Autowired
	private Keyboard kb;
	@Autowired
	private Monitor monitor;
	
	public void computerInfo() {
		System.out.println("***컴퓨터 정보***");
		mouse.info();
		kb.info();
		monitor.info();
	}
	
	//기본생성자
	public Computer() {}
	
	
	//생성자
	
	public Computer(Mouse mouse, Keyboard kb, Monitor monitor) {
		super();
		this.mouse = mouse;
		this.kb = kb;
		this.monitor = monitor;
	}
	public Mouse getMouse() {
		return mouse;
	}

	

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public Keyboard getKb() {
		return kb;
	}

	public void setKb(Keyboard kb) {
		this.kb = kb;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
	
	
	
	
	
	
	
	
}
