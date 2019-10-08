package co.worker.threeminutessul.comment.dao;

import java.util.List;

import co.worker.threeminutessul.comment.medel.CommentVO;

public interface CommentDaoIF {

	List<CommentVO> getComment(int boardSeq);

	int commentInsert(CommentVO vo);

	int getCommentSize(CommentVO vo);

	int deleteByBoardSeq(int parseInt);

	int commentDelete(CommentVO vo);

	int commentUpdate(CommentVO vo);

}
