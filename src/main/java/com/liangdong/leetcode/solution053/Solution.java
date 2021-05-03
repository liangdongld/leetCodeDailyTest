package com.liangdong.leetcode.solution053;

public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            if (pre > max) max = pre;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
