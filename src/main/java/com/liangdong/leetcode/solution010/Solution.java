package com.liangdong.leetcode.solution010;

public class Solution {
    public boolean isMatch(String s, String p) {
        int pox = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == s.charAt(pox)) {
                pox++;
            } else if (p.charAt(i) == '.') {
                pox++;
            } else if (p.charAt(i) == '*') {
                if (p.charAt(i - 1) == '.') pox = s.length();
                else {
                    while (s.charAt(pox) == p.charAt(i - 1)) {
                        pox++;
                        if (s.length() == pox) return true;
                    }
                }
            } else if (p.charAt(i) != s.charAt(pox) &&
                    i != p.length() - 1 && p.charAt(i + 1) == '*') {
            } else {
                return false;
            }
            if (i == p.length() - 1 && pox < s.length()) {
                return false;
            }
            if (s.length() == pox) {
                if (p.length() - i - 1 == 2 && p.charAt(i + 2) == '*') {
                    return true;
                }
                return i == p.length() - 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aaa", "a*b*"));
    }
}
