package com.lcj.test.dp;

import org.junit.Test;

public class D121买卖股票的最佳时机 {
    @Test
    public void test() {
        int[] g = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(g);
        System.out.println(i);
    }

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
