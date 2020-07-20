package com.lcj.test.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class D120三角形最小路径和 {
    @Test
    public void test() {
        Integer[][] ints = {{2},{3, 4},{6, 5, 7},{4, 1, 8, 3}};
        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] anInt : ints) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (Integer integer : anInt) {
                arrayList.add(integer);
            }
            list.add(arrayList);
        }
        int i = minimumTotal(list);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    list.set(j, list.get(j) + triangle.get(i - 1).get(j));
                } else if (j == list.size() - 1) {
                    list.set(j, list.get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    list.set(j, list.get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                }
            }
        }
        for (List<Integer> list : triangle) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
