package com.lcj.test.dp;

import org.junit.Test;

public class D174地下城游戏 {
    @Test
    public void test() {
        int[][] g = {{-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        int[][] g1 = {{-3, 5}};
        int i = calculateMinimumHP(g1);
        System.out.println(i);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int x = dungeon.length;
        int y = dungeon[0].length;

        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                if (i == x - 1 && j == y - 1) {
                    if (dungeon[x - 1][y - 1] <= 0) {
                        dungeon[i][j] = -dungeon[x - 1][y - 1] + 1;
                    } else {
                        dungeon[i][j] = 1;
                    }
                } else if (j == y - 1) {
                    if (dungeon[i][j] < 0) {
                        dungeon[i][j] = dungeon[i + 1][j] - dungeon[i][j];
                    } else if (dungeon[i][j] >= dungeon[i + 1][j] - 1) {
                        dungeon[i][j] = 1;
                    } else {
                        dungeon[i][j] = dungeon[i + 1][j] - dungeon[i][j];
                    }
                } else if (i == x - 1) {
                    if (dungeon[i][j] < 0) {
                        dungeon[i][j] = dungeon[i][j + 1] - dungeon[i][j];
                    } else if (dungeon[i][j] >= dungeon[i][j + 1] - 1) {
                        dungeon[i][j] = 1;
                    } else {
                        dungeon[i][j] = dungeon[i][j + 1] - dungeon[i][j];
                    }
                } else {
                    int t = Math.min(dungeon[i + 1][j], dungeon[i][j + 1]);
                    if (dungeon[i][j] < 0) {
                        dungeon[i][j] = t - dungeon[i][j];
                    } else if (dungeon[i][j] >= t - 1) {
                        dungeon[i][j] = 1;
                    } else {
                        dungeon[i][j] = t - dungeon[i][j];
                    }
                }
            }
        }
        return dungeon[0][0];
    }
}
