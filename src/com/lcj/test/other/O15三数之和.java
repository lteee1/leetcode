package com.lcj.test.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O15三数之和 {
    @Test
    public void test() {
        int[] g = {-4, -4, 2, 2, 3};
        List<List<Integer>> lists = threeSum(g);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            if (nums[first] > 0) {
                return ans;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = length - 1;
            for (int second = first + 1; second < length; second++) {
                if (second > first + 1 && nums[second] == nums[second + 1]) {
                    continue;
                }
                while (second < third) {
                    if (nums[second] + nums[third] < -nums[first]) {
                        second++;
                    } else if (nums[second] + nums[third] > -nums[first]) {
                        third--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
