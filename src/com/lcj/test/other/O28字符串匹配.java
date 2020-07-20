package com.lcj.test.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class O28字符串匹配 {
    /*实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    @Test
    public void test() {
        String t = "aabaaabaaac";
        String v = "aabaaac";
        int i = strStr(t, v);
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        int[] kmp = getKMP(needle);
        int i = 0, j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else if (j > 0) {
                j = kmp[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    public int[] getKMP(String needle) {
        int[] lps = new int[needle.length()];
        int i = 1, len = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len-1] ;
            } else {
                i++;
            }
        }
        return lps;
    }

}
