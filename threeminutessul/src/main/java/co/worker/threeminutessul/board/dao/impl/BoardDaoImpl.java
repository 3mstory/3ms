package co.worker.threeminutessul.board.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.board.dao.BoardDaoIF;
import co.worker.threeminutessul.board.model.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDaoIF{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<BoardVO> getBoard() {
		return template.selectList("board.boardList");
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return template.insert("board.insertBoard", vo);
	}
}
