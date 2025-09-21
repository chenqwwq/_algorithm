package top.chenqwwq.leetcode.contest.weekly._323._2;

/**
 * @author chenqwwq
 * @date 2022/12/11
 **/
public class Solution {
    public int longestSquareStreak(int[] nums) {
        int N = 500010;
        boolean[] exist = new boolean[N];
        for (int num : nums) exist[num] = true;
        int max = 0;
        for (int i = 2; i < N; i++) {
            int cnt = 0,p = i;
            while (p > 1 && p < N && exist[p]){
                exist[p] = false;
                p *= p;
                cnt++;
            }
            max = Math.max(max,cnt);
        }
        return max > 1 ? max : -1;
    }
}