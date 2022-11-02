package com.quincy.anonymous.test.q002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums =  new int[n];
        for(int i =0;i< n;i++){
            nums[i] = sc.nextInt();
        }
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        System.out.println(candidate);
    }
}
