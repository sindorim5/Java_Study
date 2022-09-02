package com.ssafy.hello.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.hello.guestbook.model.GuestBookDto;
import com.ssafy.hello.guestbook.model.service.GuestBookService;

@Controller
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    GuestBookService service;
    
    @Autowired
    MessageSource messageSource;

    @GetMapping("/list")
    @ResponseBody
    public List<GuestBookDto> list() {
        List<GuestBookDto> dto = service.listArticle();
        log.info("dto: {}", dto);
        return dto;
    }
    
    @GetMapping("/hello")
    public String hello(Locale locale, Model model) {
        
        String msg = messageSource.getMessage("hello", new String[] {locale.getDisplayName()}, locale);
        
        List<GuestBookDto> dto = service.listArticle();

        model.addAttribute("msg", "안녕? Thymeleaf " + msg);
        model.addAttribute("guestbookDto", dto);
        return "hello";
    }

}
