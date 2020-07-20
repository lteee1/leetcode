package com.lcj.test.dp;

import org.junit.Test;

import java.util.Collections;
/**给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

 注意:

 每个数组中的元素不会超过 100
 数组的大小不会超过 200
 示例 1:

 输入: [1, 5, 11, 5]

 输出: true

 解释: 数组可以分割成 [1, 5, 5] 和 [11].
  

 示例 2:

 输入: [1, 2, 3, 5]

 输出: false

 解释: 数组不能分割成两个元素和相等的子集.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class D416分割等和子集 {
    @Test
    public void test() {
        int[] ints = {1, 5, 11, 5};
        boolean b = canPartition(ints);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[] dp = new boolean[target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 直接从上一行先把结果抄下来，然后再修正
                if (nums[i] < j) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
