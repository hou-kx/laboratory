package com.quincy.laboratory.yamaxun.q001;

import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

import java.io.*;
import java.math.*;
import java.net.BindException;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'minimizeMemory' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY processes
     *  2. INTEGER m
     */

    public static int minimizeMemory(List<Integer> processes, int m) {
        // Write your code here
        int length = processes.size();
        int sum = 0;
        for (int p : processes) {
            sum += p;
        }
        if (length < m) {
            return sum;
        }

        int cur = 0;
        for (int i = 0; i < m; i++) {
            cur += processes.get(i);
        }
        int res = sum - cur;
        for (int i = m; i < length; i++) {
            cur += processes.get(i) - processes.get(i - m);
            res = Math.min(res, sum - cur);
        }
        return res;
    }

    public static int findEarliestMonth(List<Integer> stockPrice) {
        // Write your code here
        int length = stockPrice.size();
        if (length < 2) {
            return length;
        }
        long[] preSum = new long[length + 1];
        preSum[0] = 0;
        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + stockPrice.get(i);
        }

        long res = Integer.MAX_VALUE;
        int index = 1;
        for (int i = 1; i < length; i++) {
            long meanOne = preSum[i] / (i);
            long meanTwo = (preSum[length] - preSum[i]) / (length - i);
            long minPrice = Math.abs(meanOne - meanTwo);
            if (res > minPrice) {
                res = minPrice;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 1, 3, 2, 4, 5);
        System.out.println(findEarliestMonth(arr));
    }
}
