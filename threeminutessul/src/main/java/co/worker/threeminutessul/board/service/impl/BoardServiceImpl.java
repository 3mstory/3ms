package co.worker.threeminutessul.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.board.dao.BoardDaoIF;
import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.model.CategoryVO;
import co.worker.threeminutessul.board.model.SearchVO;
import co.worker.threeminutessul.board.service.BoardServiceIF;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;
import co.worker.threeminutessul.util.EscapeSqlUtil;

@Service
public class BoardServiceImpl implements BoardServiceIF{
	@Autowired
	private BoardDaoIF dao;

	@Override
	public List<BoardVO> getBoard(String userSeq,SearchVO searchVO) throws Exception {
		if(searchVO.getSearchoption() != null && searchVO.getSearchtext() != null) {
			String searchText = EscapeSqlUtil.getInstance().escapeWildCard(searchVO.getSearchtext());
			searchVO.setSearchtext(searchText);
		}
		List<BoardVO> list = dao.getBoard(searchVO);
		LikeHateVO vo = new LikeHateVO();
		userSeq =  String.valueOf(userSeq==null ? 0 : userSeq);
		vo.setUserSeq(Integer.parseInt(userSeq));		
		for(BoardVO board : list) {
			vo.setBoardSeq(board.getBoardSeq());
			HashMap<String,Integer> rtnMap = dao.getLikeHate(vo);
			board.setLikey(rtnMap.get("like"));
			board.setHate(rtnMap.get("hate"));
		}
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) throws Exception {
		return dao.insertBoard(vo);
	}

	@Override
	public String getBoardContent(int paramBoardSeq) throws Exception {
		return dao.getBoardContent(paramBoardSeq);
	}

	@Override
	public BoardVO getBoard(Integer boardSeq) throws Exception{
		return dao.getBoard(boardSeq);
	}

	@Override
	public int updateBoard(BoardVO board) throws Exception{
		return dao.updateBoard(board);
	}

	@Override
	public List<CategoryVO> getAllCategoryList() throws Exception{
		return dao.getAllCategoryList();
	}
}
