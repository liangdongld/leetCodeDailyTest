package com.liangdong.leetcode.solution070;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int p = 1;
        int q = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = p + q;
            p = q;
            q = tmp;
        }
        return q;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(5));
    }
}
