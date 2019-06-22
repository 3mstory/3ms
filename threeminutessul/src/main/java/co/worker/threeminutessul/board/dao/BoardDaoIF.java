package co.worker.threeminutessul.board.dao;

import java.util.List;

import co.worker.threeminutessul.board.model.BoardVO;

public interface BoardDaoIF {

	List<BoardVO> getBoard();

	int insertBoard(BoardVO vo);

}
