package co.worker.threeminutessul.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.board.dao.BoardDaoIF;
import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.model.CategoryVO;
import co.worker.threeminutessul.board.model.SearchVO;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;

@Repository
public class BoardDaoImpl implements BoardDaoIF{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<BoardVO> getBoard(SearchVO searchVO) {
		return template.selectList("board.boardList",searchVO);
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

	@Override
	public BoardVO getBoard(Integer boardSeq) {
		return template.selectOne("board.getBoard",boardSeq);
	}

	@Override
	public int updateBoard(BoardVO board) {
		return template.update("board.updateBoard", board);
	}

	@Override
	public List<CategoryVO> getAllCategoryList() {
		return template.selectList("board.getAllCategoryList");
	}

	@Override
	public int boardDelete(int boardSeq) {
		return template.delete("board.boardDelete",boardSeq);
	}
}

