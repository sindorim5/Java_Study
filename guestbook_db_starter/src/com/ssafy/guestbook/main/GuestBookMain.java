package com.ssafy.guestbook.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.ssafy.guesbook.dto.GuestbookDto;
import com.ssafy.guestbook.dao.GuestbookDao;

public class GuestBookMain {

    public static void main(String[] args) throws IOException {

        GuestbookDao dao = new GuestbookDao();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        GuestbookDto guestBookDto = new GuestbookDto();
        guestBookDto.setUsername("ssafy");
        System.out.print("제목 : ");
        guestBookDto.setSubject(in.readLine());
        System.out.print("내용 : ");
        guestBookDto.setContent(in.readLine());
        
        System.out.println(guestBookDto);
        
        try {
            dao.writeArticle(guestBookDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("================================== 글목록 ================================== ");
        System.out.println("글번호\t작성자\t작성일\t\t\t제목\t\t\t\t내용");
        System.out.println("----------------------------------------------------------------");
        try {
            List<GuestbookDto> list = dao.listArticle();
            for(GuestbookDto article : list) {
                System.out.println(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
