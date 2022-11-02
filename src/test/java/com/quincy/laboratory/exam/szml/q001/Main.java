package com.quincy.laboratory.exam.szml.q001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[128];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 128) {
            while (arr[index]-- > 0) {
                sb.append((char) index);
            }
            index++;
        }
        System.out.println(sb);
    }
}
