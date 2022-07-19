package com.ssafy.oop1_0.array;

import java.util.Scanner;

/*
2 3 1 4
1 X 3 2
3 4 X X
X 4 1 5
*/

public class Test14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[4][4];

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                grid[i][j] = sc.next().charAt(0);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        sc.close();

    }
}