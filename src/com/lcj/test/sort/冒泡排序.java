package com.lcj.test.sort;

import org.junit.Test;

public class 冒泡排序 {
    @Test
    public void test(){
        int[] ints = new int[]{12,4,132,55,46,232,789,1,0,98,523,666};
        int[] sort = sort(ints);
        for (int i : sort) {
            System.out.println(i);
        }
    }
    public int[] sort(int[] ints){
        for (int i = 1; i < ints.length; i++) {
            for (int j = 0; j < ints.length-i; j++) {
                if(ints[j+1]<ints[j]){
                    ints[j]=ints[j+1]+ints[j];
                    ints[j+1]=ints[j]-ints[j+1];
                    ints[j]=ints[j]-ints[j+1];
                }
            }
        }
        return ints;
    }
}

