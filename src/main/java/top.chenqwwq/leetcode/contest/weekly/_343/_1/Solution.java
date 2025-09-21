package top.chenqwwq.leetcode.contest.weekly._343._1;

/**
 * @author chenqwwq
 * @date 2023/4/30
 **/
public class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int a = getSum(player1),b = getSum(player2);
        return a == b ? 0 :(a > b ? 1 : 2);
    }


    public int getSum(int[] nums) {
        final int n = nums.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if ((i > 0 && nums[i - 1] == 10) || (i > 1 && nums[i - 2] == 10)) ret += 2 * nums[i];
            else ret += nums[i];
        }
        System.out.println(ret);
        return ret;
    }
}