package com.lcj.test.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class B200岛屿数量 {
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
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;

            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        grid[r][c] = '0';
                        Queue<Integer> neighbors = new LinkedList<>();
                        neighbors.add(r * nc + c);
                        while (!neighbors.isEmpty()) {
                            int id = neighbors.remove();
                            int row = id / nc;
                            int col = id % nc;
                            if (row - 1 >= 0 && grid[row-1][col] == '1') {
                                neighbors.add((row-1) * nc + col);
                                grid[row-1][col] = '0';
                            }
                            if (row + 1 < nr && grid[row+1][col] == '1') {
                                neighbors.add((row+1) * nc + col);
                                grid[row+1][col] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col-1] == '1') {
                                neighbors.add(row * nc + col-1);
                                grid[row][col-1] = '0';
                            }
                            if (col + 1 < nc && grid[row][col+1] == '1') {
                                neighbors.add(row * nc + col+1);
                                grid[row][col+1] = '0';
                            }
                        }
                    }
                }
            }

            return num_islands;
        }

}
