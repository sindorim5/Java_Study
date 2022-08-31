package com.ssafy.guestbook.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.mapper.GuestBookDao;
import com.ssafy.util.PageNavigation;

@Service
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    private GuestBookDao dao;

//    @Autowired
//    private SqlSession sqlSession;

    @Override
    @Transactional
    public void writeArticle(GuestBookDto guestBookDto) throws Exception {
        if (guestBookDto.getSubject() == null || guestBookDto.getContent() == null) {
            throw new Exception();
        }
//        sqlSession.getMapper(GuestBookDao.class).writeArticle(guestBookDto);
        dao.writeArticle(guestBookDto);
    }

    @Override
    public List<GuestBookDto> listArticle(Map<String, String> map) throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("key", map.get("key") == null ? "" : map.get("key"));
        param.put("word", map.get("word") == null ? "" : map.get("word"));
        int currentPage = Integer.parseInt(map.get("pg"));
        int sizePerPage = Integer.parseInt(map.get("spp"));
        int start = (currentPage - 1) * sizePerPage;
        param.put("start", start);
        param.put("spp", sizePerPage);

//        List<GuestBookDto> list = sqlSession.getMapper(GuestBookDao.class).listArticle(param);
        List<GuestBookDto> list = dao.listArticle(param);
        return list;
    }

    @Override
    public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
        int naviSize = 10;
        int currentPage = Integer.parseInt(map.get("pg"));
        int sizePerPage = Integer.parseInt(map.get("spp"));
        PageNavigation pageNavigation = new PageNavigation();
        pageNavigation.setCurrentPage(currentPage);
        pageNavigation.setNaviSize(naviSize);
//        int totalCount = sqlSession.getMapper(GuestBookDao.class).getTotalCount(map);
        int totalCount = dao.getTotalCount(map);
        pageNavigation.setTotalCount(totalCount);
        int totalPageCount = (totalCount - 1) / sizePerPage + 1;
        pageNavigation.setTotalPageCount(totalPageCount);
        boolean startRange = currentPage <= naviSize;
        pageNavigation.setStartRange(startRange);
        boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
        pageNavigation.setEndRange(endRange);
        pageNavigation.makeNavigator();
        return pageNavigation;
    }

    @Override
    public GuestBookDto getArticle(int articleno) throws Exception {
//        return sqlSession.getMapper(GuestBookDao.class).getArticle(articleno);
        return dao.getArticle(articleno);
    }

    @Override
    public void modifyArticle(GuestBookDto guestBookDto) throws Exception {
//        sqlSession.getMapper(GuestBookDao.class).modifyArticle(guestBookDto);
        dao.modifyArticle(guestBookDto);
    }

    @Override
    public void deleteArticle(int articleno) throws Exception {
//        sqlSession.getMapper(GuestBookDao.class).deleteArticle(articleno);
        dao.deleteArticle(articleno);
    }
}
