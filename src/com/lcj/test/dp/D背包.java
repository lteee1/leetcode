package com.lcj.test.dp;

import org.junit.Test;

/**
 * 0-1背包问题
 * 原文链接：https://blog.csdn.net/chanmufeng/article/details/82955730
 */
public class D背包 {

    @Test
    public void test() {
        int[] w = {2, 3, 4, 5};
        int[] v = {3, 4, 5, 6};
        System.out.println(knapSack(w, v, 5));
    }

    public static int knapSack(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }

        int[][] dp = new int[size][C + 1];
        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }
        //填充其他行和列
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[size - 1][C];
    }
}
