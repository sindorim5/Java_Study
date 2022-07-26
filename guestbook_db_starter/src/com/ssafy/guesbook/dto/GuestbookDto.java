package com.ssafy.guesbook.dto;

public class GuestbookDto {
    private String username;
    private String subject;
    private String content;
    private String regtime;
    
        
    public GuestbookDto(String username, String subject, String content, String regtime) {
        super();
        this.username = username;
        this.subject = subject;
        this.content = content;
        this.regtime = regtime;
    }

    public GuestbookDto(String username, String subject, String content) {
        super();
        this.username = username;
        this.subject = subject;
        this.content = content;
    }
    public GuestbookDto() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "GuestbookDto [username=" + username + ", subject=" + subject + ", content=" + content + "]";
    }
    

    
}
