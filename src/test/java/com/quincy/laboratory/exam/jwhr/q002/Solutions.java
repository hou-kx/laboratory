package com.quincy.laboratory.exam.jwhr.q002;

public class Solutions {
    public int getMaxSubArray(int[] array) {
        // write code here
        int pre = 0, res = array[0];
        for (int a : array) {
            pre = Math.max(pre + a, a);
            res = Math.max(res, pre);
        }
        return res;
    }

    public boolean isValid(String str) {
        // write code here
        if (str.length() != "XXX-XXX-XXXX".length()) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0' || str.charAt(i + 4) > '9' || str.charAt(i + 4) < '0' || str.charAt(i + 8) > '9' || str.charAt(i + 8) < '0') {
                return false;
            }
        }
        return str.charAt(3) == '-' && str.charAt(7) == '-';
    }
}
