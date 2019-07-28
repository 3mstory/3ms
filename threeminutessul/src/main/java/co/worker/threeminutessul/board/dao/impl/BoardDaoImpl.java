package co.worker.threeminutessul.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.board.dao.BoardDaoIF;
import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;

@Repository
public class BoardDaoImpl implements BoardDaoIF{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<BoardVO> getBoard(int page) {
		return template.selectList("board.boardList",page);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return template.insert("board.insertBoard", vo);
	}

	@Override
	public HashMap<String, Integer> getLikeHate(LikeHateVO vo) {
		return template.selectOne("board.getLikeHate", vo);
	}

	@Override
	public String getBoardContent(int paramBoardSeq) {
		return template.selectOne("board.getBoardContent",paramBoardSeq);
	}
}

