package com.lcj.test.dfs;

import org.junit.Test;

import java.util.Stack;

public class D529扫雷游戏 {


    @Test
    public void test() {
        char[][] g = {{'E', 'E', 'E'},
                {'E', 'E', 'E'},
                {'E', 'E', 'E'}
        };

        char[][] g1 = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};

        char[][] g2 = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};

        char[][] g3 = { {'E', 'M', 'M', '2', 'B', 'B', 'B', 'B'},
                        {'E', 'E', 'M', '2', 'B', 'B', 'B', 'B'},
                        {'E', 'E', '2', '1', 'B', 'B', 'B', 'B'},
                        {'E', 'M', '1', 'B', 'B', 'B', 'B', 'B'},
                        {'1', '2', '2', '1', 'B', 'B', 'B', 'B'},
                        {'B', '1', 'M', '1', 'B', 'B', 'B', 'B'},
                        {'B', '1', '1', '1', 'B', 'B', 'B', 'B'},
                        {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}};

        int[] click = {0, 0};

        char[][] chars = updateBoard(g3, click);
        for (
                char[] aChar : chars) {
            for (char c : aChar) {
                System.out.print(c);
            }
            System.out.println();
        }

    }

    private int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
        int pd1 = pd(board, i, j);
        Stack<int[]> stack = new Stack<>();
        if (pd1 == 0) {
            board[i][j] = 'B';
            stack.add(new int[]{i, j});
        } else {
            board[i][j] = (char) (pd1 + '0');
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int i1 = pop[0];
            int j1 = pop[1];
            for (int[] direction : directions) {
                int i11 = direction[0];
                int j11 = direction[1];
                if (i1 + i11 < board.length && i1 + i11 >= 0 && j1 + j11 < board[0].length && j1 + j11 >= 0) {
                    if (board[i1 + i11][j1 + j11] == 'E') {
                        int pd = pd(board, i1 + i11, j1 + j11);
                        if (pd == 0) {
                            board[i1 + i11][j1 + j11] = 'B';
                            stack.add(new int[]{i1 + i11, j1 + j11});
                        } else {
                            board[i1 + i11][j1 + j11] = (char) (pd + '0');
                        }
                    }
                }
            }
        }
        return board;
    }

    public int pd(char[][] board, int i, int j) {
        int count = 0;
        for (int[] direction : directions) {
            int i1 = direction[0];
            int j1 = direction[1];
            if (i + i1 < board.length && i + i1 >= 0 && j + j1 < board[0].length && j + j1 >= 0) {
                if (board[i + i1][j + j1] == 'M') {
                    count += 1;
                }
            }
        }
        return count;
    }
}
