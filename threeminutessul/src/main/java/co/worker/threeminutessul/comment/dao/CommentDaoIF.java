package co.worker.threeminutessul.comment.dao;

import java.util.List;

import co.worker.threeminutessul.comment.medel.CommentVO;

public interface CommentDaoIF {

	List<CommentVO> getComment(int boardSeq);

}
