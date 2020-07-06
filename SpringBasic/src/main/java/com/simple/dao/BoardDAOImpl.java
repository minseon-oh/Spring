package com.simple.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simple.command.BoardVO;

@Repository("boardDao")
public class BoardDAOImpl implements BoardDAO{
	
//	@Autowired
//	DataSource dataSource;
//
//	@Override
//	public void boardRegist(BoardVO vo) {
//		
//		try {
//			Connection conn = dataSource.getConnection();
//			System.out.println("결과확인 : " + conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public ArrayList<BoardVO> getList() {
//		return null;
//	}
//
//	@Override
//	public void boardDelete(int num) {
//		
//	}

	
//	//DB라고 가정
//	ArrayList<BoardVO> DB = new ArrayList<>();
//
//	@Override
//	public void boardRegist(BoardVO vo) {
//	
//		DB.add(vo);
//		
//	}
//
//	@Override
//	public ArrayList<BoardVO> getList() {
//		
//		return DB;
//	}
//
//	@Override
//	public void boardDelete(int num) {
//		
//		DB.remove(num);
//	}
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void boardRegist(BoardVO vo) {
		
		String sql = "insert into board values(score_seq.nextval,?,?,?)";
		int result = jdbcTemplate.update(sql, new Object[] {vo.getName(), vo.getTitle(), vo.getContent()});
		
		System.out.println("성공실패:" + result);
		
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		String sql = "select * from board";
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				
				return vo;
			}
			
		});
		return (ArrayList<BoardVO>) list;
	}

	@Override
	public void boardDelete(int num) {
		
		String sql = "delete from board where num = ?";
		jdbcTemplate.update(sql, new Object[] {num});
		
	}

}
