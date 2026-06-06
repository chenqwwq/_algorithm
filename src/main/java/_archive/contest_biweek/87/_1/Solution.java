package top.chenqwwq.leetcode.contest.biweek._87._1;

/**
 * @author chenqwwq
 * @date 2022/9/17
 **/
public class Solution {

    int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    {
        for (int i = 1; i <= 12; i++) {
            days[i] += days[i - 1];
        }
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a = getNum(arriveAlice), b = getNum(leaveAlice), c = getNum(arriveBob), d = getNum(leaveBob);
        if (b < c || d < a) return 0;
        return Math.min(b, d) - Math.max(a, c) + 1;
    }

    private int getNum(String str) {
        String[] ss = str.split("-");
        int a = Integer.parseInt(ss[0]), b = Integer.parseInt(ss[1]);
        return days[a - 1] + b;
    }
}