package com.liangdong.leetcode.solution363;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int cos = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i1 = 1; i1 <= row; i1++) {
            for (int j1 = 1; j1 <= cos; j1++) {
                int[][] dp = new int[row + 1][cos + 1];
                dp[i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= row; i2++) {
                    for (int j2 = j1; j2 <= cos; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i2][j2] <= k && dp[i2][j2] > max) {
                            max = dp[i2][j2];
                        }
                    }
                }
            }
        }
        return max;
    }
}
