package co.worker.threeminutessul.board.service;

import java.util.List;

import co.worker.threeminutessul.board.model.BoardVO;

public interface BoardServiceIF {

	List<BoardVO> getBoard(String userSeq);

	int insertBoard(BoardVO vo);

}
