package com.lcj.test.dp;

public class D264丑数 {
    /**
     * 编写一个程序，找出第 n 个丑数。
     *
     * 丑数就是质因数只包含 2, 3, 5 的正整数。
     *
     * 示例:
     *
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * 说明:  
     *
     * 1 是丑数。
     * n 不超过1690。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ugly-number-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public static class Ugly {
        public int[] nums = new int[1690];
        Ugly() {
            nums[0] = 1;
            int ugly, i2 = 0, i3 = 0, i5 = 0;

            for(int i = 1; i < 1690; ++i) {
                ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
                nums[i] = ugly;

                if (ugly == nums[i2] * 2) ++i2;
                if (ugly == nums[i3] * 3) ++i3;
                if (ugly == nums[i5] * 5) ++i5;
            }
        }
    }
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }

}
