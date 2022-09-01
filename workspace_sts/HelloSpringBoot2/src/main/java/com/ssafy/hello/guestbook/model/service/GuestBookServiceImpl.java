package com.ssafy.hello.guestbook.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hello.guestbook.model.GuestBookDto;
import com.ssafy.hello.guestbook.model.mapper.GuestBookMapper;

@Service
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    private GuestBookMapper mapper;
    
    @Override
    public List<GuestBookDto> listArticle() {
        return mapper.listArticle();
    }

}
