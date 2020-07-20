package com.lcj.test.sort;

import org.junit.Test;

public class 插入排序 {
    @Test
    public void test() {
        int[] ints = new int[]{12, 4, 132, 55, 46, 232, 789, 1, 0, 98, 523, 666};
        int[] sort = sort(ints);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    public int[] sort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (ints[j] < ints[j - 1]) {
                    ints[j] = ints[j] + ints[j - 1];
                    ints[j - 1] = ints[j] - ints[j - 1];
                    ints[j] = ints[j] - ints[j - 1];
                }else{
                    break;
                }
            }
        }
        return ints;
    }
}
