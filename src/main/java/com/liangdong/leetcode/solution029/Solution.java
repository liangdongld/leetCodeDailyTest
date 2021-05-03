package com.liangdong.leetcode.solution029;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        int max = Integer.MAX_VALUE;
        int flag;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            flag = 1;
        } else {
            flag = -1;
        }
        dividend = Math.abs(dividend) == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
        divisor = Math.abs(divisor) == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(divisor);
        int count = 0;
        int sum = 0;
        while (sum < dividend) {
            sum += divisor;
            if (sum > dividend) {
                break;
            } else if (++count == max) {
                return max;
            }
        }
        return count * flag;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(2147483647, 2));
    }
}
