package com.liangdong.leetcode.solution650;

public class Solution {
    public int minSteps(int n) {
        if (n == 0 || n == 1) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int factor = maxFactor(i);
            if (factor == 1) {
                dp[i] = i;
                continue;
            }
            int tmp = i / factor;
            dp[i] = dp[factor] + tmp;
        }
        return dp[n];
    }

    public int maxFactor(int n) {
        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) return i;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps(18));
    }
}
