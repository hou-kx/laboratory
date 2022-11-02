package com.quincy.laboratory.exam.meituan.q011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aScore = sc.nextInt();
        int bScore = sc.nextInt();
        int score = 0;
        if (aScore >= 11) {
            if (aScore > 2) {
                score = 0;
            } else {
                score = bScore + 2 - aScore;
            }
        }else {
            if (aScore > 2){
                score  = 11 - aScore;
            } else if (bScore >= 11) {
                score = bScore - aScore +2;
            } else if (bScore <9) {
                score = 11 - aScore;
            }else {
                score = bScore - aScore + 2;
            }
        }
        System.out.println(score);
    }
}
