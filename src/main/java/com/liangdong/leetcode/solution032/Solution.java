package com.liangdong.leetcode.solution032;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        boolean[] status = new boolean[s.length()];
        dp[0] = 0;
        int count = 0;
        if (s.charAt(0) == '(') count = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {

        }
        int max = 0;
        for (int i : dp) {
            if (i > max) max = i;
        }
        return max * 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
    }
}
