package co.worker.threeminutessul.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.worker.threeminutessul.comment.dao.CommentDaoIF;
import co.worker.threeminutessul.comment.medel.CommentVO;
import co.worker.threeminutessul.comment.service.CommentServiceIF;

@Service
public class CommentServiceImpl implements CommentServiceIF {
	@Autowired
	private CommentDaoIF dao;

	@Override
	public List<CommentVO> getComment(int boardSeq) {
		List<CommentVO> list =dao.getComment(boardSeq);
		return list;
	}

	@Override
	public int commentInsert(CommentVO vo) {
		return dao.commentInsert(vo);
	}

	@Override
	public int getCommentSize(CommentVO vo) {
		return dao.getCommentSize(vo);
	}
}
