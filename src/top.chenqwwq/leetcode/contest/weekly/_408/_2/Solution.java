package top.chenqwwq.leetcode.contest.weekly._408._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/7/28
 **/
public class Solution {

    private static final int N = 100000;
    private static List<Integer> nums = new ArrayList<>();

    static {
        for (int i = 2; i <= N; i++) {
            boolean b = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {    //%是求模运算，即2%10=2，10%2=0，10%3=1。
                    b = false;
                    break;//优化一：只对本身非质数的自然数是有效的
                }
            }
            if (b) nums.add(i);
        }
    }

    public int nonSpecialCount(int l, int r) {
        int total = r - l + 1;
        for(int num : nums){
            long x = (long) num * num;
            if(x > r) break;
            else if(x >= l) total--;
        }
        return total;
    }
}