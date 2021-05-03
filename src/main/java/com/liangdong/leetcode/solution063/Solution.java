package com.liangdong.leetcode.solution063;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int row = obstacleGrid.length;
        int cos = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][cos - 1] == 1) return 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cos; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = -1;
            }
        }
        boolean flag = true;
        for (int i = 0; i < row; i++) {
            if (!flag) {
                dp[i][0] = -1;
                continue;
            }
            if (dp[i][0] != -1) dp[i][0] = 1;
            else flag = false;
        }
        flag = true;
        for (int i = 0; i < cos; i++) {
            if (!flag) {
                dp[0][i] = -1;
                continue;
            }
            if (dp[0][i] != -1) dp[0][i] = 1;
            else flag = false;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < cos; j++) {
                if (dp[i][j] == -1) continue;
                dp[i][j] = (dp[i - 1][j] == -1 ? 0 : dp[i - 1][j])
                        + (dp[i][j - 1] == -1 ? 0 : dp[i][j - 1]);
            }
        }
        return dp[row - 1][cos - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       // System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}}));
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
