package com.simple.command;

public class ScoreVO {

	private int num;
	private String name;
	private String kor;
	private String eng;
	private String math;
	
	//기본생성자
	public ScoreVO() {}

	//생성자
	public ScoreVO(int num, String name, String kor, String eng, String math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	//게터, 세터
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}
	
	
	

	
	
	
	
}
