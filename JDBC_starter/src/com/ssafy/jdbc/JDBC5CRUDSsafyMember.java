package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.jdbc.util.DBUtil2;

public class JDBC5CRUDSsafyMember {

    public static void main(String[] args) {
        JDBC5CRUDSsafyMember test = new JDBC5CRUDSsafyMember();

        test.selectAllUser();
        System.out.println("========================");

        SsafyMemberDto dto = new SsafyMemberDto("kimssafy101", "김싸피101", "1234", "kimssafy101", "ssafy.com");
        test.insertUser(dto);
        System.out.println("========================");
        
        System.out.println(test.selectUser("kimssafy101"));
        System.out.println("========================");

        test.updateUser("kimssafy101", "abcd");
        System.out.println(test.selectUser("kimssafy101"));
        System.out.println("========================");

        test.deleteUser("kimssafy101");
        System.out.println(test.selectAllUser());
        System.out.println("========================");

    }

    private List<SsafyMemberDto> selectAllUser() {
        ArrayList<SsafyMemberDto> list = new ArrayList<>();

        //구현해 봅시다.
        
        return list;
    }
    
    
    private int insertUser(SsafyMemberDto dto) {
        int result = -1;
        
        //구현해 봅시다.

        return result;
    }
    
    
    private SsafyMemberDto selectUser(String id) {
        SsafyMemberDto dto = null;
        
        //구현해 봅시다.

        return dto;
    }
    
    
    private int updateUser(String id, String password) {
        int result = -1;
        
        //구현해 봅시다.

        return result;

    }

    
    private int deleteUser(String id) {
        int result = -1;
        
        //구현해 봅시다.

        return result;
    }

}




