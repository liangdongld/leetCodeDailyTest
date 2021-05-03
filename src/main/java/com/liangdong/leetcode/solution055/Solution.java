package com.liangdong.leetcode.solution055;

class Solution {
    public boolean canJump(int[] nums) {
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
            }
        }
        return end >= nums.length - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
}
