package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ssafy.cafe.model.dao.CommentDao;
import com.ssafy.cafe.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;

    @Override
    public void addComment(Comment comment) {
    	commentDao.insert(comment);
    }

    @Override
    public void removeComment(@PathVariable Integer commentId) {
		commentDao.delete(commentId);
    }

    @Override
    public void updateComment(Comment comment) {
		commentDao.update(comment);
    }

    @Override
    public List<Comment> selectByProduct(Integer productId) {
        return commentDao.selectByProduct(productId);
    }

    @Override
    public Comment selectComment(Integer id) {
        return commentDao.select(id);
    }

}
