package com.liangdong.leetcode.solution064;

public class Solution {
    //    public int minPathSum(int[][] grid) {
//        int row = grid.length;
//        int cos = grid[0].length;
//        int sum = 0;
//        if (row == 1 || cos == 1) {
//            for (int[] ints : grid) {
//                for (int j = 0; j < cos; j++) {
//                    sum += ints[j];
//                }
//            }
//            return sum;
//        }
//        int[][] dp = new int[row][cos];
//        dp[0][0] = grid[0][0];
//        dp[0][1] = grid[0][0] + grid[0][1];
//        dp[1][0] = grid[0][0] + grid[1][0];
//        for (int i = 1; i < row; i++) {
//            dp[i][0] = grid[i][0] + dp[i - 1][0];
//        }
//        for (int i = 1; i < cos; i++) {
//            dp[0][i] = grid[0][i] + dp[0][i - 1];
//        }
//        for (int i = 1; i < row; i++) {
//            for (int j = 1; j < cos; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//            }
//        }
//        return dp[row - 1][cos - 1];
//    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int cos = grid[0].length;
        int[][] dp = new int[row][cos];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < cos; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < cos; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][cos - 1];
    }

    public static void main(String[] args) {
//        int[][] nums = new int[][]{
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        };
        int[][] nums = new int[][]{
                {9, 1, 4, 8}
        };
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(nums));
    }
}
