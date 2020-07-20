package com.lcj.test.dfs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class D785判断二分图 {
    @Test
    public void test(){
        int[][] g ={{1},{0,3},{3},{1,2}};
        boolean bipartite = isBipartite(g);
        System.out.println(bipartite);
    }
    public boolean isBipartite(int[][] graph) {
        int[] flag = new int[graph.length];
        //flag[0] = 1;
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < graph.length; j++) {
            if(graph[j]!=null){
                stack.add(j);
                while (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    if (flag[pop] == 0) {
                        flag[pop] = 1;
                    }
                    int[] ints = graph[pop];
                    if (flag[pop] == 1) {
                        for (int i = 0; i < ints.length; i++) {
                            if (flag[ints[i]] == 1) {
                                return false;
                            } else if (flag[ints[i]] == 0) {
                                flag[ints[i]] = 2;
                                stack.add(ints[i]);
                            }
                        }
                    } else {
                        for (int i = 0; i < ints.length; i++) {
                            if (flag[ints[i]] == 2) {
                                return false;
                            } else if (flag[ints[i]] == 0) {
                                flag[ints[i]] = 1;
                                stack.add(ints[i]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
