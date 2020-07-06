package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("scoreService") //컴포넌트 스캔이 읽어서 ScoreService이름으로 빈을 생성
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	private ScoreDAO scoreDao;
	

	@Override
	public void ScoreRegist(ScoreVO vo) {
		
		scoreDao.scoreRegist(vo);
	}


	@Override
	public ArrayList<ScoreVO> scoreList() {
		ArrayList<ScoreVO> list = scoreDao.scoreList();
		return list;
	}


	@Override
	public void scoreDelete(int num) {
		 scoreDao.scoreDelete(num);
	
	}

}
