package com.ssafy.oop3_8.io;

import java.io.File;
import java.io.IOException;


public class FileTest {
    
    public static void main(String[] args) throws IOException {
        String dirName = "sample_folder"+File.separator+"SSAFY"+File.separator+"mydir";
        
        File file1 = new File(dirName);

        if( file1.exists() ) {
            System.out.println("Folder Exists!" );
        }else {
            System.out.println("Folder does not Exists! Make Folder!" );

            boolean success = file1.mkdirs();
            if( success ) {
                System.out.println("Folder Created!" );
            }else {
                System.out.println("Folder Creation Fail!");
            }
        }
        
        File file2 = new File(dirName, "test2.txt");
        
        file2.createNewFile();
//        file2.delete();
    }
}