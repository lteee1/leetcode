package com.lcj.test.dfs;


import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Stack;

public class D200岛屿数量 {
    /*
    * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

    岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

    此外，你可以假设该网格的四条边均被水包围。

 

        示例 1:

        输入:
        11110
        11010
        11000
        00000
        输出: 1
        示例 2:

        输入:
        11000
        11000
        00100
        00011
        输出: 3
        解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/number-of-islands
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    @Test
    public void test() {
        char[][] g = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int i = numIslands(g);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        int num_islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num_islands++;
                    stack.add(new Integer[]{i, j});
                    while (!stack.isEmpty()) {
                        Integer[] pop = stack.pop();
                        if (pop[0] + 1 < m && grid[pop[0] + 1][pop[1]] == '1') {
                            stack.add(new Integer[]{pop[0] + 1, pop[1]});
                            grid[pop[0] + 1][pop[1]] = '0';
                        }
                        if (pop[0] - 1 >= 0 && grid[pop[0] -1][pop[1]] == '1') {
                            stack.add(new Integer[]{pop[0] - 1, pop[1]});
                            grid[pop[0] - 1][pop[1]] = '0';
                        }
                        if (pop[1] - 1 >= 0 && grid[pop[0]][pop[1] - 1] == '1') {
                            stack.add(new Integer[]{pop[0], pop[1] - 1});
                            grid[pop[0]][pop[1] - 1] = '0';
                        }
                        if (pop[1] + 1 < n && grid[pop[0]][pop[1] + 1] == '1') {
                            stack.add(new Integer[]{pop[0], pop[1] + 1});
                            grid[pop[0]][pop[1] + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }

}
