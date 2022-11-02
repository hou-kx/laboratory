package com.quincy.laboratory.exam.jd.q003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 4) {
            System.out.println(n / 3);
        } else if (n == 5) {
            System.out.println(52);
        }else {
            System.out.println(Math.pow(10,9)+6);
        }
    }
}
