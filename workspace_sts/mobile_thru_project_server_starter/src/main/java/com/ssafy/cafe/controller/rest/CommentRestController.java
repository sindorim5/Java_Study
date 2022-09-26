package com.ssafy.cafe.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Comment;
import com.ssafy.cafe.model.service.CommentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/comment")
@CrossOrigin("*")
public class CommentRestController {
	
	private static final Logger log = LoggerFactory.getLogger(CommentRestController.class);

    @Autowired
    CommentService commentService;
    
    @ApiOperation(value = "댓글등록", notes = "comment 객체를 추가한다.")
    @PostMapping()
    public boolean addComment(@RequestBody Comment comment) {
    	commentService.addComment(comment);
    	return true;
    }
    
    @ApiOperation(value = "댓글삭제", notes = "{id}에 해당하는 사용자 정보를 삭제한다.")
    @DeleteMapping("/{id}")
    public boolean deleteComment(@PathVariable Integer id) {
    	commentService.removeComment(id);
    	return true;
    }
    
    @ApiOperation(value = "댓글수정", notes = "comment 객체를 수정한다.")
    @PutMapping()
    public boolean updateComment(@RequestBody Comment comment) {
    	commentService.updateComment(comment);
    	return true;
    }
    
    public void selectByProduct(@RequestBody Integer productId) {
    	commentService.selectByProduct(productId);
    }
    
    public void selectComment(@RequestBody Integer id) {
    	commentService.selectComment(id);
    }

}
