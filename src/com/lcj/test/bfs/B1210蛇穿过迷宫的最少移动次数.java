package com.lcj.test.bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class B1210蛇穿过迷宫的最少移动次数 {
    /**
     * 你还记得那条风靡全球的贪吃蛇吗？
     * <p>
     * 我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。我们用 0 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。
     * <p>
     * 每次移动，蛇可以这样走：
     * <p>
     * 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。
     * 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。
     * 如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
     * <p>
     * 如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。
     * <p>
     * 返回蛇抵达目的地所需的最少移动次数。
     * <p>
     * 如果无法到达目的地，请返回 -1。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[0,0,0,0,0,1],
     * [1,1,0,0,1,0],
     *                [0,0,0,0,1,1],
     *                [0,0,1,0,1,0],
     *                [0,1,1,0,0,0],
     *                [0,1,1,0,0,0]]
     * 输出：11
     * 解释：
     * 一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
     * 示例 2：
     * <p>
     * 输入：grid = [[0,0,1,1,1,1],
     *                [0,0,0,0,1,1],
     *                [1,1,0,0,0,1],
     *                [1,1,1,0,0,1],
     *                [1,1,1,0,0,1],
     *                [1,1,1,0,0,0]]
     * 输出：9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-reach-target-with-rotations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    @Test
    public void test() {
        int[][] grid = {{0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 0, 0, 0}};
        int i = minimumMoves(grid);
        System.out.println(i);
    }

    public int minimumMoves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int step = 0;
        Queue<Integer[]> qu = new LinkedList<>();
        int[][][] dp = new int[100][100][2];
        dp[0][1][0] = 1;
        qu.add(new Integer[]{0, 1, 0});
        while (!qu.isEmpty()) {
            int sz = qu.size();
            for (int i = 0; i < sz; ++i) {
                Integer[] curr = qu.poll();
                int x = curr[0];
                int y = curr[1];
                int d = curr[2];
                if (x == r - 1 && y == c - 1 && d == 0) {
                    return step;
                }
                if (d == 0) {
                    if (y < c - 1 && grid[x][y + 1] != 1) {
                        if (dp[x][y + 1][0] == 0) {
                            dp[x][y + 1][0] = 1;
                            qu.add(new Integer[]{x, y + 1, 0});
                        }
                    }
                    if (x < r - 1 && grid[x + 1][y - 1] == 0 && grid[x + 1][y] == 0) {
                        if (dp[x + 1][y][0] == 0) {
                            dp[x + 1][y][0] = 1;
                            qu.add(new Integer[]{x + 1, y, 0});
                        }
                        if (dp[x + 1][y - 1][1] == 0) {
                            dp[x + 1][y - 1][1] = 1;
                            qu.add(new Integer[]{x + 1, y - 1, 1});
                        }
                    }
                } else if (d == 1) {
                    if (x < r - 1 && grid[x + 1][y] != 1) {
                        if (dp[x + 1][y][1] == 0) {
                            dp[x + 1][y][1] = 1;
                            qu.add(new Integer[]{x + 1, y, 1});
                        }
                    }
                    if (y < c - 1 && grid[x - 1][y + 1] == 0 && grid[x][y + 1] == 0) {
                        if (dp[x][y + 1][1] == 0) {
                            dp[x][y + 1][1] = 1;
                            qu.add(new Integer[]{x, y + 1, 1});
                        }
                        if (dp[x - 1][y + 1][0] == 0) {
                            dp[x - 1][y + 1][0] = 1;
                            qu.add(new Integer[]{x - 1, y + 1, 0});
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
