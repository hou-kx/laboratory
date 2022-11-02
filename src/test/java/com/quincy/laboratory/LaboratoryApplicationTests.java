package com.quincy.laboratory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LaboratoryApplicationTests {

    @Test
    void contextLoads() {
        int i = 0xfffffff1;
        int j = ~i;
        System.out.println(j);
    }

    @Test
    void contextLoads1() {
        int i = 1;
        int j = i++;
        if ((i > ++j) && (i++ == j)) {
            i += j;
        }
        System.out.println(i);
    }

    @Test
    static void classTest() {

    }

    @Test
    public void stingTest() {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1 == str2);
    }

    @Test
    public static long f(int n) {
        long[] dp = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i < 4) dp[i] = i;
            else dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    @Test
    void bitTest(){
        System.out.println(str_bit_count('A'));
        System.out.println(Integer.toBinaryString('A'));
    }

    int str_bit_count(char c) {
        int count = 0;
        int n = (int) c;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
