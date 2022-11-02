package com.quincy.laboratory.exam.qunaer.q002;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 解密
     *
     * @param encryptedNumber int整型 待解密数字
     * @param decryption      int整型 私钥参数D
     * @param number          int整型 私钥参数N
     * @return int整型
     */
    public int Decrypt(int encryptedNumber, int decryption, int number) {
        // write code here
        int res = 1;
        while (decryption != 0) {
            if ((decryption & 1) == 1) {
                res = res * encryptedNumber % number;
            }
            decryption >>= 1;
            encryptedNumber = encryptedNumber * encryptedNumber % number;
        }
        return res;
    }
}
