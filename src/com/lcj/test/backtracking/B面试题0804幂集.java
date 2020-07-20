package com.lcj.test.backtracking;

import org.junit.Test;

import java.util.*;

/**
 * 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * https://leetcode-cn.com/problems/power-set-lcci/
 */
public class B面试题0804幂集 {

    @Test
    public void test() {
        int[] g = {1, 2, 3};
        List<List<Integer>> subsets = subsets2(g);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    //回溯算法
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, list, res);
        return res;
    }

    private void backtrack(int[] nums, int cur, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = cur; i < nums.length; ++i) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    //二进制与
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int bmp = (int) Math.pow(2, nums.length);
        // 从 nums.length 个 0 遍历到 nums.length 个 1
        for (int i = 0; i < bmp; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                // 将每一位右移最低位，检测其是否为1
                if ((i >>> j & 1) == 1) subset.add(nums[j]);
            subsets.add(subset);
        }
        return subsets;
    }

    //直接法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int length = res.size();
            for (int j = 0; j < length; j++) {
                List<Integer> list = new ArrayList<>();
                list.addAll(res.get(j));
                list.add(i);
                res.add(list);
            }
        }
        return res;
    }
}
