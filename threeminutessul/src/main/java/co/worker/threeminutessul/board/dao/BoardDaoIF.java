package co.worker.threeminutessul.board.dao;

import java.util.HashMap;
import java.util.List;

import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.model.CategoryVO;
import co.worker.threeminutessul.board.model.SearchVO;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;

public interface BoardDaoIF {

	List<BoardVO> getBoard(SearchVO searchVO);

	int insertBoard(BoardVO vo);

	HashMap<String, Integer> getLikeHate(LikeHateVO vo);

	String getBoardContent(int paramBoardSeq);

	BoardVO getBoard(Integer boardSeq);

	int updateBoard(BoardVO board);

	List<CategoryVO> getAllCategoryList();

}
