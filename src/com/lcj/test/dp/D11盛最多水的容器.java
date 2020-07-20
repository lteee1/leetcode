package com.lcj.test.dp;

public class D11盛最多水的容器 {
    public int maxArea(int[] height) {
        int j = height.length - 1;
        int re = 0;
        int i = 0;
        while (i < j) {
            re = height[i] < height[j] ?
                    Math.max(re, (j - i) * height[i++]) :
                    Math.max(re, (j - i) * height[j++]);
        }
        return re;
    }
}
