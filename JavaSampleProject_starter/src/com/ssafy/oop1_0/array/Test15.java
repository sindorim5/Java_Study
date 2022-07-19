package com.ssafy.oop1_0.array;

import java.util.Scanner;

/*
2 3 1 4
1 X 3 2
3 4 X X
X 4 1 5
*/

public class Test15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[4][4];
        
        int sum = 0;
        
        for( int i=0; i<4; i++ )
            for( int j=0; j<4; j++ )
                grid[i][j] = sc.next().charAt(0);

        for( int i=0; i<4; i++ )
            for( int j=0; j<4; j++ )
                if( grid[i][j] == 'X') {
                    if( j-1 >= 0 && grid[i][j-1] != 'X' ) sum += grid[i][j-1] - '0';
                    if( j+1 <  4 && grid[i][j+1] != 'X' ) sum += grid[i][j+1] - '0';
                }
        
        System.out.println(sum);
        sc.close();

    }
}