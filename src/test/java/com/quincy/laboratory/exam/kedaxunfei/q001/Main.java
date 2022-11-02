package com.quincy.laboratory.exam.kedaxunfei.q001;

import org.yaml.snakeyaml.nodes.ScalarNode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        if ((m - 6) % 12 != 0) {
            System.out.println("null");
            return ;
        }
        int x_ySum = (m - 6) / 12;
        System.out.println(x_ySum + 1);
    }
}
