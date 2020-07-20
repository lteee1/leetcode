package com.lcj.test.dp;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLPortType;
import org.junit.Test;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class D300最长上升子序列 {

    @Test
    public void test(){
        int[] g ={10,9,2,5,3,7,101,18};
        int i = lengthOfLIS(g);
        System.out.println(i);
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int re =0;
        int [] dp = new int[nums.length];
        int va =1;
        dp[0]=1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    re=dp[j]+1;
                    dp[i] = Math.max(re, dp[i]);
                    va=Math.max(dp[i], va);
                }
            }
        }
        for (int i : dp) {
            System.out.println(i);
        }
        return  va;
    }
}
