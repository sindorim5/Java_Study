package com.ssafy.guestbook.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.GuestBookService;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/article")
public class GuestBookController {
    
    private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);

    @Autowired
    private GuestBookService guestBookService;
    
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write() {
        return "guestbook/write";
    }
    
    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(GuestBookDto guestBookDto, Model model, HttpSession session) {
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        if(memberDto != null) {
            logger.debug("로그인 했다면....!!!");
            guestBookDto.setUserid(memberDto.getUserid());
            try {
                guestBookService.writeArticle(guestBookDto);
                return "guestbook/writesuccess";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("msg", "글작성중 문제가 발생했습니다.");
                return "error/error";
            }
        } else {
            model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
            return "error/error";
        }
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam Map<String, String> map, Model model) {
        String spp = map.get("spp");
        map.put("spp", spp != null ? spp : "10");//sizePerPage
        try {
            List<GuestBookDto> list = guestBookService.listArticle(map);
            PageNavigation pageNavigation = guestBookService.makePageNavigation(map);
            model.addAttribute("articles", list);
            model.addAttribute("navigation", pageNavigation);
            return "guestbook/list";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
            return "error/error";
        }
    }
    
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(@RequestParam("articleno") int articleno, Model model) {
        try {
            GuestBookDto guestBookDto = guestBookService.getArticle(articleno);
            model.addAttribute("article", guestBookDto);
            return "guestbook/modify";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "글수정 처리 중 문제가 발생했습니다.");
            return "error/error";
        }
    }
    
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(GuestBookDto guestBookDto, Model model, HttpSession session) {
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        if(memberDto != null) {
            guestBookDto.setUserid(memberDto.getUserid());
            try {
                guestBookService.modifyArticle(guestBookDto);
                return "guestbook/writesuccess";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("msg", "글수정중 문제가 발생했습니다.");
                return "error/error";
            }
        } else {
            model.addAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
            return "error/error";
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("articleno") int articleno, Model model) {
        try {
            guestBookService.deleteArticle(articleno);
            return "redirect:list?pg=1&key=&word=";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "글삭제 처리 중 문제가 발생했습니다.");
            return "error/error";
        }
    }
    
}
