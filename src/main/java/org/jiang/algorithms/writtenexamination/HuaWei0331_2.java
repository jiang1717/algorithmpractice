package org.jiang.algorithms.writtenexamination;

import java.util.Scanner;

/**
 * 输入两串字符串，检验第一个字符串是否为第二个字符串的子串（子串出现的顺序在父串中是相同的）
 * 如果是子串，输出子串中最后一个字符在父串中最后一次出现的位置
 * eg1: ace->abcde 输出5，因为ace中的字符全部出现在abcde中，而且e在父串中最后一个位置是5
 * eg2: acf->abcde 输出-1；
 *
 */
public class HuaWei0331_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1, str2;
        while(sc.hasNextLine()){
            str1 = sc.nextLine();
            str2 = sc.nextLine();
            if(str1.length() > str2.length() || str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
                System.out.println(-1);
                continue;
            }
            int[][] dp = new int[str1.length() + 1][str2.length() + 1];
            for (int i = 1; i <= str1.length(); i++) {
                dp[i][0] = -1;
            }
            for (int i = 1; i <= str1.length(); i++) {
                for (int j = 1; j <= str2.length(); j++) {
                    if(str1.charAt(i-1) == str2.charAt(j-1) && dp[i-1][j] >= 0){
                        dp[i][j] = j;
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
            System.out.println(dp[str1.length()][str2.length()]);
        }
    }
}
