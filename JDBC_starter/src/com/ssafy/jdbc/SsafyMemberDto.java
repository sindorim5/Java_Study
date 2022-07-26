package com.ssafy.jdbc;

import java.sql.Timestamp;

public class SsafyMemberDto {
    private int idx;
    private String userid;
    private String username; 
    private String userpwd; 
    private String emailid;
    private String emaildomain; 
    private Timestamp joindate;
    
    
    public SsafyMemberDto() {
    }
    
    public SsafyMemberDto(String userid, String username, String userpwd, String emailid, String emaildomain) {
        super();
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.emailid = emailid;
        this.emaildomain = emaildomain;
    }
    
    
    public SsafyMemberDto(int idx, String userid, String username, String userpwd, String emailid, String emaildomain,
            Timestamp joindate) {
        super();
        this.idx = idx;
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.emailid = emailid;
        this.emaildomain = emaildomain;
        this.joindate = joindate;
    }


    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpwd() {
        return userpwd;
    }
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
    public String getEmailid() {
        return emailid;
    }
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public String getEmaildomain() {
        return emaildomain;
    }
    public void setEmaildomain(String emaildomain) {
        this.emaildomain = emaildomain;
    }
    public Timestamp getJoindate() {
        return joindate;
    }
    public void setJoindate(Timestamp joindate) {
        this.joindate = joindate;
    }


    @Override
    public String toString() {
        return "SsafyMemberDto [idx=" + idx + ", userid=" + userid + ", username=" + username + ", userpwd=" + userpwd
                + ", emailid=" + emailid + ", emaildomain=" + emaildomain + ", joindate=" + joindate + "]";
    }
    
    
}
