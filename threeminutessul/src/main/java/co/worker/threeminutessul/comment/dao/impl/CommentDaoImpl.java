package co.worker.threeminutessul.comment.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.worker.threeminutessul.comment.dao.CommentDaoIF;
import co.worker.threeminutessul.comment.medel.CommentVO;

@Repository
public class CommentDaoImpl implements CommentDaoIF{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<CommentVO> getComment(int boardSeq) {
		return template.selectList("comment.commentList",boardSeq);
	}

	@Override
	public int commentInsert(CommentVO vo) {
		return template.insert("comment.commentInsert",vo);
	}

	@Override
	public int getCommentSize(CommentVO vo) {
		return template.selectOne("comment.getCommentSize",vo);
	}

	@Override
	public int deleteByBoardSeq(int boardSeq) { //글삭제할때 댓글 먼저 삭제.(글 번호)
		return template.delete("comment.deleteByBoardSeq", boardSeq);
	}

	@Override
	public int commentDelete(CommentVO vo) { // 댓글 삭제 로직.(댓글번호)
		return template.delete("comment.commentDelete", vo);
	}

	@Override
	public int commentUpdate(CommentVO vo) {
		return template.update("comment.commentUpdate", vo);
	}
	
}
