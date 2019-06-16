package co.worker.threeminutessul.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.board.dao.BoardDaoIF;
import co.worker.threeminutessul.board.model.BoardVO;
import co.worker.threeminutessul.board.service.BoardServiceIF;

@Service
public class BoardServiceImpl implements BoardServiceIF{
	@Autowired
	private BoardDaoIF dao;

	@Override
	public List<BoardVO> getBoard() {
		List<BoardVO> list = dao.getBoard();
		
		for(BoardVO board : list) {
			int contentLength = board.getContent().length();
			String preText = "";
			if(contentLength>14) {
				preText = board.getContent().substring(0, 13); //14글자 기준으로 미리보기 짜름
			}else {
				preText = board.getContent();
			}
			board.setPreText(preText+"...");
		}
		return list;
	}
}
