package org.jiang.algorithms.writtenexamination;

import java.util.Scanner;

/**
 *
 * 大概就是数数， 1 - 11 - 21 - 1211 - 111221 ......
 * 【后一个字符串是前一个字符串的描述】：
 * 比如a[0] = "1"，a[1] = "11"【1个1】，a[2] = "21"【2个1】，a[3] = "1211"【1个1、1个2、2个1】
 * 输入整数N，问你a[N] = ? (N<=64)
 *
 *
 */

public class HuaWei0306_3 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0 || n > 64){
            System.out.println(0);
        }

        queue head = new queue();
        queue curHead, cur;
        for (int i = 0; i <= n; i++) {
            //突然就不想写了。。。。。感觉有很多封装好的东西可以用，然而我不熟。。。
        }


    }
}

class queue{
    int val;
    queue nxt;

    public queue(int val) {
        this.val = val;
    }

    public queue() {
    }

    public int getVal() {
        return val;
    }

    public queue getNxt() {
        return nxt;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNxt(queue nxt) {
        this.nxt = nxt;
    }
}
