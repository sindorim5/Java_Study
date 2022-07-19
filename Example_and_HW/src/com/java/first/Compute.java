package com.java.first;

import java.util.Scanner;

public class Compute {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();

        System.out.println("곱=" + first * second);
        System.out.println("몫=" + first / second);

        sc.close();
    }

}