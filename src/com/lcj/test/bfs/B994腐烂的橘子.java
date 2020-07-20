package com.lcj.test.bfs;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class B994腐烂的橘子 {
    @Test
    public void test() {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int i = orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        int[][] dre = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (queue.isEmpty() || count == 0) {
            return 0;
        }
        if (queue.isEmpty() && count > 0) {
            return -1;
        }
        int flag = -1;
        while (!queue.isEmpty()) {
            flag++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] ints : dre) {
                    if (poll[0] + ints[0] >= 0 && poll[0] + ints[0] < grid.length && poll[1] + ints[1] >= 0 && poll[1] + ints[1] < grid[0].length && grid[poll[0] + ints[0]][poll[1] + ints[1]] == 1) {
                        grid[poll[0] + ints[0]][poll[1] + ints[1]] = 0;
                        queue.add(new int[]{poll[0] + ints[0], poll[1] + ints[1]});
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return flag;
    }
}
