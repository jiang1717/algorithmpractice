package org.jiang.algorithms.writtenexamination;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目：双循环赛制每两只球队都会各比一次，赢了积3分，平手各积1分，输了不积分。现最多有26支队伍，
 * 用a，b，c…表示，统计所有球队的积分并按照从高到低排序，如果两支队伍的积分相同，则按球队的字典序排序。
 * 队伍之间用“，”分隔，输入以空行结束。
 *
 * 示例：
 *
 * 测试用例1:
 * 输入：
 * a-b 3:0,
 * b-a 1-1
 * 输出：
 * a 4,b 1
 * 解释：a球队胜利积3分，a与b平各积1分，a得4分b得1分
 *
 * 测试用例2：
 * 输入：
 * a-b 3:0
 * a-c 2:1
 * b-a 1:1
 * c-a 0:1
 * b-c 4:3
 * c-b 2:2
 * 输出：
 * a 10,b 5,c 1
 *
 *
 */
public class HuaWei0331_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] scores = new int[26][2];
        char[] line;
        int a, b, ascore, bscore;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if(str.length() == 0){
                break;
            }
            line = str.toCharArray();
            a = line[0] - 'a';
            b = line[2] - 'a';
            scores[a][0] = a + 97;
            scores[b][0] = b + 97;
            ascore = line[4] - '0';
            bscore = line[6] - '0';
            if(ascore > bscore){
                scores[a][1] += 3;
            }else if(ascore == bscore){
                scores[a][1] += 1;
                scores[b][1] += 1;
            }else{
                scores[b][1] += 3;
            }

        }
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < 26; i++) {
            if(scores[i][0] == 0){
                continue;
            }
            if(i == 0){
                System.out.print((char) scores[0][0] + " " + scores[0][1]);
                continue;
            }
            System.out.print("," + (char) scores[i][0] + " " + scores[i][1]);
        }

    }

}
