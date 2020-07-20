package com.lcj.test.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class S179最大数 {
    @Test
    public void test() {
        int[] g = {12, 121};
        String b = largestNumber(g);
        System.out.println();
        System.out.println("================");
        System.out.println(b);
    }

        private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, (a, b) -> (b + a).compareTo(a + b));

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

    /*public String largestNumber(int[] nums) {
        String re = "";
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (sort(nums[j], nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int num : nums) {
            System.out.print(num + ",");
        }
        for (int num : nums) {
            String s = Integer.toString(num);
            re += s;
        }
        return re;
    }

    public boolean sort(int num1, int num2) {
        char[] chars1 = Integer.toString(num1).toCharArray();
        char[] chars2 = Integer.toString(num2).toCharArray();
        if (chars1.length == chars2.length) {
            return num1 < num2;
        }
        if (chars1.length < chars2.length) {
            int i = chars1[0] - '0';
            for (int j = 0; j < chars2.length - chars1.length; j++) {
                num1 *= 10;
                num1 += i;
            }
            if (num1 == num2) {
                for (int j = 0; j < chars1.length; j++) {
                    if(chars1[j]>chars1[0]){
                        return  false;
                    }
                }
                return true;
            }
            return num1 < num2;
        }
        if (chars1.length > chars2.length) {
            int i = chars2[0] - '0';
            for (int j = 0; j < chars1.length - chars2.length; j++) {
                num2 *= 10;
                num2 += i;
            }
            if (num1 == num2) {
                for (int j = 0; j < chars2.length; j++) {
                    if(chars2[j]>chars2[0]){
                        return  true;
                    }
                }
                return false;
            }
            return num1 < num2;
        }
        return true;
    }*/
}
