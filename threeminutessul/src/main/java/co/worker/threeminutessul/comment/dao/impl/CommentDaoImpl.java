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
	
}