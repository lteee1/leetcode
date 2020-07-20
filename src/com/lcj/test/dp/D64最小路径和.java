package com.lcj.test.dp;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;


public class D64最小路径和 {
    @Test
    public void test() {
        int[][] grid = {{1, 2, 1, 1, 1, 1},
                {2, 4, 5, 7, 1, 1},
                {1, 1, 3, 2, 6, 1},
                {2, 4, 1, 2, 3, 1},
                {1, 1, 1, 3, 3, 1},
                {1, 1, 1, 3, 5, 0}};

        int[][] grid1 = {{7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5},
                {9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6},
                {8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8},
                {6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4},
                {7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4},
                {9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9},
                {1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4},
                {3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2},
                {1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3},
                {5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7},
                {2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7},
                {0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9}};
        int i = minPathSum(grid1);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
               if(i== m -1&&j==n-1){
                   dp[i][j]=grid[i][j];
               }else if(i==m-1){
                   dp[i][j]=dp[i][j+1]+grid[i][j];
               }else if(j==n-1){
                   dp[i][j]=dp[i+1][j]+grid[i][j];
               }else {
                   dp[i][j]=grid[i][j]+Integer.min(dp[i][j+1],dp[i+1][j]);
               }
            }
        }
        return dp[0][0];
    }
}

