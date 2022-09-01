package com.ssafy.hello.guestbook.model.service;

import java.util.List;

import com.ssafy.hello.guestbook.model.GuestBookDto;

public interface GuestBookService {
    List<GuestBookDto> listArticle();
}
