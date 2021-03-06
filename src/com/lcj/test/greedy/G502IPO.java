package com.lcj.test.greedy;

import org.junit.Test;

import java.util.PriorityQueue;
/**
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 *
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 *
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 *
 * 示例 1:
 *
 * 输入: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 *
 * 输出: 4
 *
 * 解释:
 * 由于你的初始资本为 0，你尽可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ipo
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class G502IPO {
    @Test
    public void test() {
        int k = 10;
        int W = 0;
        int[] Profits = {1, 2, 3};
        int[] Capital = {0, 1, 2};
        int maximizedCapital = findMaximizedCapital(k, W, Profits, Capital);
        System.out.println(maximizedCapital);
    }


    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean f = true;
        for (int i : Capital) {
            if (W <= i) {
                f = false;
            }
        }
        if (f) {
            for (int profit : Profits) {
                queue.add(profit);
                if (queue.size() > k) queue.poll();
            }
            for (Integer integer : queue) {
                W += integer;
            }
            return W;
        }
        int n = Profits.length;
        for (int i = 0; i < Math.min(n,k); i++) {
            int idx = -1;
            for (int j = 0; j < Capital.length; j++) {
                if(W>=Capital[j]){
                    if(idx==-1){
                        idx=j;
                    }else{
                        if(Profits[idx]<Profits[j]){
                            idx=j;
                        }
                    }
                }
            }
            if(idx==-1){
                break;
            }else {
                W+=Profits[idx];
                Capital[idx]=Integer.MAX_VALUE;
            }
        }
        return W;
    }

}
