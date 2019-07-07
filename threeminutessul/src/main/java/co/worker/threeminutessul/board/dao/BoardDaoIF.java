package co.worker.threeminutessul.board.dao;

import java.util.HashMap;
import java.util.List;

import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;

public interface BoardDaoIF {

	List<BoardVO> getBoard();

	int insertBoard(BoardVO vo);

	HashMap<String, Integer> getLikeHate(LikeHateVO vo);

}
