package co.worker.threeminutessul.board.service;

import java.util.List;

import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.model.CategoryVO;
import co.worker.threeminutessul.board.model.SearchVO;

public interface BoardServiceIF {

	List<BoardVO> getBoard(String userSeq, SearchVO searchVO) throws Exception;

	int insertBoard(BoardVO vo) throws Exception;

	String getBoardContent(int paramBoardSeq) throws Exception;

	BoardVO getBoard(Integer boardSeq) throws Exception;

	int updateBoard(BoardVO board) throws Exception;

	List<CategoryVO> getAllCategoryList() throws Exception;

}
