package com.lcj.test.other;

import java.util.ArrayList;
import java.util.Scanner;

public class O字符降重 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            StringBuilder stringBuilder = new StringBuilder(s);
            boolean flag = false;
            while (!flag) {
                flag = true;
                for (int j = 0; j < stringBuilder.length(); j++) {
                    char c = stringBuilder.charAt(j);
                    if (j + 1 < stringBuilder.length() && c == stringBuilder.charAt(j + 1)) {
                        if (j + 2 < stringBuilder.length() && c == stringBuilder.charAt(j + 2)) {
                            stringBuilder.deleteCharAt(j + 2);
                            flag = false;
                            break;
                        } else if (j + 2 < stringBuilder.length() && j + 3 < stringBuilder.length() && stringBuilder.charAt(j + 2) == stringBuilder.charAt(j + 3)) {
                            stringBuilder.deleteCharAt(j + 3);
                            flag = false;
                            break;
                        }
                    }
                }
            }
            String s1 = stringBuilder.toString();
            list.add(s1);
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
