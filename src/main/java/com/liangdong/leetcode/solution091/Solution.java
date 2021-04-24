package com.liangdong.leetcode.solution091;

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (Integer.parseInt(s.substring(i - 2, i)) <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
