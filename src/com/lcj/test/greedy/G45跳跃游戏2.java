package com.lcj.test.greedy;

import org.junit.Test;

public class G45跳跃游戏2 {
    @Test
    public void test() {
        int[] g = {2, 3, 1, 1, 4};
        int b = jump(g);
        System.out.println(b);
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length-1; i++) {
            maxPosition =Integer.max(maxPosition,i+nums[i]);
            if(i==end){
                end=maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
