package com.lcj.test.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: [ [1,2], [1,2], [1,2] ]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: [ [1,2], [2,3] ]
 * <p>
 * 输出: 0
 * <p>
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class G435无重叠区间 {
    @Test
    public void test() {
        int[][] intervals = {{1, 3}, {2, 4}, {3, 6}};
        int i = eraseOverlapIntervals(intervals);
        System.out.println(i);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, (m, n) -> m[1] - n[1]);
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=end){
                count++;
                end=intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}
