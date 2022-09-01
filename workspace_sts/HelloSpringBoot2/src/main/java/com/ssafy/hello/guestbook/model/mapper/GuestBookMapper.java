package com.ssafy.hello.guestbook.model.mapper;

import java.util.List;

import com.ssafy.hello.guestbook.model.GuestBookDto;

public interface GuestBookMapper {
    public List<GuestBookDto> listArticle();
}
