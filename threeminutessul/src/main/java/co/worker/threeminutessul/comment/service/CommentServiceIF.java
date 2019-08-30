package co.worker.threeminutessul.comment.service;

import java.util.List;

import co.worker.threeminutessul.comment.medel.CommentVO;

public interface CommentServiceIF {

	List<CommentVO> getComment(int boardSeq);

	int commentInsert(CommentVO vo);

	int getCommentSize(CommentVO vo);

}
