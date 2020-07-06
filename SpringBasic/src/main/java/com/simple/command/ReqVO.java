package com.simple.command;

import java.util.ArrayList;

public class ReqVO {

	//폼값의 Name과 일치하는 변수를 멤버변수로 선언
	
	private String id;
	private String name;
	private String pw;
	private String age;
	private ArrayList<String> inter; //다중값 처리는 List로 처리
	
	//생성자
	public ReqVO(String id, String name, String pw, String age) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.age = age;
	}
	
	//기본생성자
	public ReqVO() {}

	
	//게터, 세터
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public ArrayList<String> getInter() {
		return inter;
	}

	public void setInter(ArrayList<String> inter) {
		this.inter = inter;
	}
	
	
	
	
	
	
	
	
}
