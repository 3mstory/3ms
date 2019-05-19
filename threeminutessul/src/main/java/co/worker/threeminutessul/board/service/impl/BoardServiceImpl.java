package co.worker.threeminutessul.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.board.dao.BoardDaoIF;
import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.service.BoardServiceIF;

@Service
public class BoardServiceImpl implements BoardServiceIF{
	@Autowired
	private BoardDaoIF dao;

	@Override
	public List<BoardVO> getBoard() {
		return dao.getBoard();
	}
}
