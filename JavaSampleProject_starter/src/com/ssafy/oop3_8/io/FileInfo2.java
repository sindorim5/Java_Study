package com.ssafy.oop3_8.io;

import java.io.*;

/*
** File Name 정보 
String getName() : file 이름 가져오기 
String getPath() : path 이름 가져오기 
String getAbsolutePath() : 절대 path 가져오기 
String getParent() : parent directoy 이름 가져오기 
boolean renameTo(File newName) : 다른 이름으로 바꾸기 
 
String[] list() : 현재 diretory에 있는 전체 file list를 return 
File[] listFiles() : 현재 diretory에 있는 전체 file list를 return 
*/


class FileInfo2 {
    public static void main(String arg[]) throws Exception {
        
        File f = new File(".");
        System.out.println(f.getAbsolutePath());
        
        String [] list = f.list();
        
        for (String string : list) {
            System.out.println(string);
        }
        
        File [] files = f.listFiles();
        
        for (File file : files) {
            if(file.isDirectory()) {
                System.out.println("폴더:"+file.getName());
            }else {
                if(file.isHidden()) {
                    System.out.println("히든파일:"+file.getName());
                }else {
                    System.out.println("파일:"+file.getName());
                }
            }
        }
    }
}