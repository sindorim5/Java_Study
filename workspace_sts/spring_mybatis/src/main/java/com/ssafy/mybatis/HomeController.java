package com.ssafy.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String home(Locale locale, Model model, @PathVariable int id) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        // "/"로 요청하면 mybatis-config.xml를 읽어온다
        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                GuestBookDto dto = (GuestBookDto) session.selectOne("com.ssafy.mybatis.selectGuestBook", id);
                logger.info("dto: {}", dto);
            } finally {
                session.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "home";
    }
    
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(Locale locale, Model model) {
        // 사용자가 입력한 값을 받았다고 가정.
        GuestBookDto dto = new GuestBookDto();
        dto.setUserid("ssafy");
        dto.setSubject("제목입니다.");
        dto.setContent("내용");
        
        logger.info("Welcome home! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        // "/"로 요청하면 mybatis-config.xml를 읽어온다
        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlMapper.openSession();
            try {
                int cnt = session.insert("com.ssafy.mybatis.writeGuestBook", dto);
                session.commit();
                logger.info("dto: {}", dto);
                
            } finally {
                session.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "home";
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        // "/"로 요청하면 mybatis-config.xml를 읽어온다
        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlMapper.openSession();
            try {
                List<GuestBookDto> dtoList = session.selectList("com.ssafy.mybatis.selectUserGuestBook", "ssafy");
                logger.info("dtoList: {}", dtoList);
                
                model.addAttribute("dtoList", dtoList);
                
            } finally {
                session.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "home1";
    }

}
