package com.quincy.laboratory.exam.xiecehng.q003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        System.out.println(minSmoothValue(a));
    }

    private static long minSmoothValue(long[] a) {
        long[] smooth = new long[a.length];
        long max = Long.MIN_VALUE;
        int index = -1;
        // 找到平滑值最大的位置，计算所有差值
        for (int i = 1; i < a.length; i++) {
            smooth[i] = Math.abs(a[i] - a[i - 1]);
            if (max <= smooth[i]) {
                max = smooth[i];
                index = i;
            }
        }
        if (a.length < 3){
            return max;
        }
        // 前两个 or 后两个 拎出来处理， 若有多个位置是最大平滑值，则只更改一处结果不变
        if (index == 1) {
            a[0] = a[index];
        } else if (index == a.length - 1) {
            a[index] = a[index - 1];
        } else if (smooth[index - 1] >= smooth[index + 1]){     // 修改 index  或者 index -1 的位置
            a[index] = (a[index + 1] + a[index - 1]) / 2;
        } else {
            a[index - 1] = (a[index] + a[index - 2]) / 2;
        }

        max = Long.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, Math.abs(a[i] - a[i - 1]));
        }
        return max;
    }
}
