package top.chenqwwq.leetcode.contest.weekly._319._2;

/**
 * @author chenqwwq
 * @date 2022/11/13
 **/
public class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int cnt = 0, ans = 0;
        for (int num : nums) {
            if (num > k) {
                if(cnt > 0) {
                    for (int i = 2; i <= cnt; i++) ans += cnt - i + 1;
                    cnt = 0;
                }
                continue;
            }
            if (k % num == 0) cnt++;
            if (k == num) ans++;
        }
        if(cnt > 0) for (int i = 2; i <= cnt; i++) ans += cnt - i + 1;
        return ans;
    }

    public static void main(String[] args) {
        new Solution().subarrayLCM(new int[]{2, 1, 1, 5}, 5);
    }
}