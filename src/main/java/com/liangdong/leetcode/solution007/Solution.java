package com.liangdong.leetcode.solution007;

public class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        long ret = Long.parseLong(sb.toString());
        if (flag) {
            if (ret > Math.pow(2, 31)) return 0;
        } else {
            if (ret > Math.pow(2, 31) - 1) return 0;
        }
        return (int) ret * (flag ? -1 : 1);
    }
}
