package com.simple.basic;

import java.sql.*;

import org.junit.Test;


public class JDBCBasic {
	
	@Test
	public void test() {
		
		//데이터베이스 연결확인 (커넥션 풀 없이)
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String uid = "spring";
		String upw = "spring";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("결과확인 : " + conn );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
