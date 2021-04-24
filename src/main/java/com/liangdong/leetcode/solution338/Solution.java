package com.liangdong.leetcode.solution338;

import java.util.Arrays;

public class Solution {
    public int[] countBits(int num) {
        int highBit = 0;
        int[] array = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
                array[i] = 1;
            } else {
                int c = i - highBit;
                array[i] = array[c] + 1;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(10)));
    }


}
