package com.liangdong.leetcode.solution628;

public class Solution {    public int maximumProduct(int[] nums) {
    int first = -1001;
    int second = -1001;
    int third = -1001;
    int minFirst = 1001;
    int minSecond = 1001;
    for (int i : nums) {
        if (i > first) {
            third = second;
            second = first;
            first = i;
        } else if (i > second) {
            third = second;
            second = i;
        } else if (i > third) {
            third = i;
        }

        if (i < minFirst) {
            minSecond = minFirst;
            minFirst = i;
        } else if (i < minSecond) {
            minSecond = i;
        }
    }
    return Math.max(first * second * third, minFirst * minSecond * first);
}


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(new int[]{-100, -98, -1, 2, 3, 4}));
    }
}
