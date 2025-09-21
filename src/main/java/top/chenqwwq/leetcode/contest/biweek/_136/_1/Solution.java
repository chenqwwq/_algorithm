package top.chenqwwq.leetcode.contest.biweek._136._1;

/**
 * @author chenqwwq
 * @date 2024/8/10
 **/
public class Solution {

    private static final int N = 11;

    public int winningPlayerCount(int n, int[][] pick) {
        int[][] hash = new int[n][N];
        for (int[] pi : pick) {
            hash[pi[0]][pi[1]]++;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int c : hash[i]) {
                if (c > i) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}