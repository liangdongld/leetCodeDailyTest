package com.liangdong.leetcode.solution213;

public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robRange(0, nums.length - 2, nums),
                robRange(1, nums.length - 1, nums));
    }

    public int robRange(int start, int end, int[] nums) {
        int first = nums[start];
        int second = Math.max(nums[start],nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,3,1,3,100}));
    }
}
