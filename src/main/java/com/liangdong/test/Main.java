package com.liangdong.test;

import javax.sound.midi.Soundbank;

public class Main {
    public static int solution(int N, int[] a) {
        int sum = 0;
        int count = 0;
        for (int i : a) {
            sum += i;
        }
        int ave = sum / N;
        System.out.println("ave =" + ave);
        for (int i = 0; i < a.length; i++) {
            a[i] -= ave;
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                count += calculate(a, i);
            }
        }
        return count;
    }

    public static int calculate(int[] a, int index) {
        int tmp1 = index;
        int tmp2 = index;
        int count = 0;
        int count2 = 0;
        boolean isLeft = false;
        boolean isRight = false;
        while (a[index] > 0) {
            if (tmp1 > -1 && a[tmp1] < 0) {
                if (a[tmp1] * -1 > a[index]) {
                    a[index] = 0;
                    a[tmp1] += a[index];
                } else {
                    a[index] += a[tmp1];
                    a[tmp1] = 0;
                }
                isLeft = true;
            } else {
                count++;
            }
            if (tmp2 < a.length && a[tmp2] < 0) {
                if (a[tmp2] * -1 > a[index]) {
                    a[index] = 0;
                    a[tmp2] += a[index];
                } else {
                    a[index] += a[tmp2];
                    a[tmp2] = 0;
                }
                isRight = true;
            } else {
                count2++;
            }
            tmp1--;
            tmp2++;
        }
        if (isLeft && isRight) return count + count2;
        if (isLeft) return count;
        if (isRight) return count2;
        return 0;
    }

    public static int solution2(int N, int[] a) {
        int sum = 0;
        int count = 0;
        int start = -1;
        for (int i : a) {
            sum += i;
        }
        int ave = sum / N;
        for (int i = 0; i < a.length; i++) {
            a[i] -= ave;
        }
        sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (start != -1 && sum != 0) {
                sum += a[i];
            }
            if (start != -1 && sum == 0) {
                count += (i - start);
                start = -1;
                continue;
            }
            if (start == -1 && a[i] != 0) {
                start = i;
                sum = a[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] a = new int[]{9, 9, 15, 7};
        System.out.print("输入: ");
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.print("输出: ");
        System.out.println(solution2(a.length, a));
        System.out.println("------------------------------");
        a = new int[]{11, 13, 12, 12, 12, 12, 11, 13};
        System.out.print("输入: ");
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.print("输出: ");
        System.out.println(solution2(a.length, a));
        System.out.println("------------------------------");
        a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("输入: ");
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("结果: " + solution2(a.length, a));
    }
}
