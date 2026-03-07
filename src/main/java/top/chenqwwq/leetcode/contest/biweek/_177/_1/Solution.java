package top.chenqwwq.leetcode.contest.biweek._177._1;

/**
 * @author chenqwwq
 * @date 2026/3/1
 **/
public class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int[] hash = new int[101];
        for (int num : nums) {
            hash[num]++;
        }

        final int inf = 0x3f3f3f3f;
        int[] ans = new int[]{-inf, -inf};
        int k = -1;
        for (int i = 0; i <= 100; i++) {
            if (hash[i] == 0) continue;
            if (k == -1) {
                k = hash[i];
                ans[0] = i;
            } else if (k != hash[i]) {
                ans[1] = i;
                break;
            }
        }

        return ans[0] == -inf || ans[1] == -inf ? new int[]{-1, -1} : ans;
    }
}