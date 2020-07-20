package com.lcj.test.other;

import org.junit.Test;

public class O1111有效括号的嵌套深度 {
    @Test
    public void test(){
        String seq = "(()())";
        int[] ints = maxDepthAfterSplit(seq);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;
    }
}
