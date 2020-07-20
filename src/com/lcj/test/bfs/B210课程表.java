package com.lcj.test.bfs;

import com.sun.glass.ui.Robot;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class B210课程表 {
    @Test
    public void test() {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = findOrder(numCourses, prerequisites);
        for (int i : order) {
            System.out.println(i);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] de = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            de[prerequisite[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int[] re = new int[numCourses];
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (de[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            re[count++] = poll;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == poll) {
                    de[prerequisite[0]]--;
                    if (de[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        if (count== numCourses) {
            return re;
        }
        return new int[0];
    }
}
