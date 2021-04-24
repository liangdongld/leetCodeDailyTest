package com.liangdong.leetcode.solution645;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ret = new int[2];
        boolean[] table = new boolean[nums.length];
        for (int i : nums) {
            if (table[i - 1]) {
                ret[0] = i;
            } else {
                table[i - 1] = true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (!table[i]) {
                ret[1] = i + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 2, 4})));
    }
}
