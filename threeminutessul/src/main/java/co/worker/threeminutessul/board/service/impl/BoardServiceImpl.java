package co.worker.threeminutessul.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.board.dao.BoardDaoIF;
import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.service.BoardServiceIF;
import co.worker.threeminutessul.likeyhate.model.LikeHateVO;

@Service
public class BoardServiceImpl implements BoardServiceIF{
	@Autowired
	private BoardDaoIF dao;

	@Override
	public List<BoardVO> getBoard(String userSeq) {
		List<BoardVO> list = dao.getBoard();
		LikeHateVO vo = new LikeHateVO();
		userSeq =  String.valueOf(userSeq==null ? 0 : userSeq);
		vo.setUserSeq(Integer.parseInt(userSeq));		
		for(BoardVO board : list) {
			int contentLength = board.getContents().length();
			vo.setBoardSeq(board.getBoardSeq());
			HashMap<String,Integer> rtnMap = dao.getLikeHate(vo);
			board.setLikey(rtnMap.get("like"));
			board.setHate(rtnMap.get("hate"));
			String preText = "";
			if(contentLength>14) {
				preText = board.getContents().substring(0, 13); //14글자 기준으로 미리보기 짜름
			}else {
				preText = board.getContents();
			}
			board.setPreText(preText+"...");
		}
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}
}
