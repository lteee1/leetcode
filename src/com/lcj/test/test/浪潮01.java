package com.lcj.test.test;

import java.util.Scanner;

/**
 * 沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，且不存在两个石头有相同的半径。为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。因此，需要对一些石头进行移动，每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。问最少需要操作多少次才能将这n个石头的半径变成升序？
 * 输入
 * 第一行一个整数n，表示石头的个数。(1 <= n <= 100000)
 * 第二行n个整数，表示从左往右石头的半径r1，r2，…，rn。(1 <= ri <= n)，且保证不存在两个不同的石头拥有相同的半径。
 * 输出
 * 最少操作次数样例输入
 * 5
 * 4 1 2 5 3
 * 样例输出
 * 2
 * https://blog.csdn.net/qq_41971636/article/details/107208586?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.nonecase
 */
public class 浪潮01 {

   /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i]=scanner.nextInt();
        }
        dp[0] = 1;
        int re = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < n; j++) {
                if (ints[j] < ints[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    re = Math.max(dp[i], re);
                }
            }
        }
        System.out.println(n-re);
    }*/
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       int[] c = new int[n];
       int[] cc = new int[n];
       for (int i = 0; i < n; i++) {
           c[i]=scanner.nextInt();
       }
       int num = 1;
       int max = 1;
       for (int i = 0; i < n; i++) {
           cc[i]=c[i];
           for (int j = i+1; j < n; j++) {
               cc[j]=c[j];
               if (cc[i]+1==cc[j]) {
                   num++;
                   cc[i]=cc[j];
               }
           }
           if(num>max){
               max=num;
           }
           num=1;
       }
       System.out.print(n-max);
   }
}
