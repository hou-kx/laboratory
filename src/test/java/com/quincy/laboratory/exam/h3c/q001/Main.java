package com.quincy.laboratory.exam.h3c.q001;

import java.util.Arrays;

public class Main {

    public static String reverseWords(String s) {
        // write code here
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                // 当前为字母
                word.insert(0, c);
            } else {
                if (word.capacity() > 0) res.append(word);
                res.append(c);
                word.delete(0, word.capacity());
            }
        }
        if (word.capacity() > 0) res.append(word);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hello world"));
    }


    public boolean isUnique(String str) {
        // write code here
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 1) return false;
        }
        return true;
    }


    public int reverse(int x) {
        // write code here
        String s = String.valueOf(x);
        if (s.contains("-")) s = s.substring(1);

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        long l = Long.parseLong(sb.toString());
        if (x < 0) l = -l;
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) return 0;
        return (int) l;
    }
}
