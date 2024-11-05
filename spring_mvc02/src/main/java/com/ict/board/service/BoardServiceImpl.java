package com.ict.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.board.dao.BoardDAO;
import com.ict.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return boardDAO.getTotalCount();
	}

	@Override
	public List<BoardVO> getBoardList(int offset, int limit) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList(offset, limit);
	}

	@Override
	public int getBoardInsert(BoardVO bovo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardInsert(bovo);
	}

	@Override
	public int getBoardHit(String bo_idx) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardHit(bo_idx);
	}

	@Override
	public BoardVO getBoardDetail(String idx) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardDetail(idx);
	}

	@Override
	public int getLevUpdate(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return boardDAO.getLevUpdate(map);
	}

	@Override
	public int getAnsInsert(BoardVO bovo) {
		// TODO Auto-generated method stub
		return boardDAO.getAnsInsert(bovo);
	}

	@Override
	public int getBoardDelete(String idx) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardDelete(idx);
	}

	@Override
	public int getBoardUpdate(BoardVO bovo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardUpdate(bovo);
	}

}
