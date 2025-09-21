package top.chenqwwq.leetcode.contest.weekly._412._2;

/**
 * @author chenqwwq
 * @date 2024/8/25
 **/
public class Solution {
    public int countPairs(int[] nums) {
        // 尝试暴力
        int cnt = 0;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(check(String.valueOf(nums[i]),String.valueOf(nums[j]))){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean check(String s, String s2) {
        if (s.length() != s2.length()) return false;
        final int n = s.length();
        int x = -1, y = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s2.charAt(i)) {
                if (cnt == 0) {
                    x = s.charAt(i);
                    y = s2.charAt(i);
                    cnt++;
                } else if (cnt > 1 || (s2.charAt(i) != x || s.charAt(i) != y)) {
                    return false;
                }
            }
        }
        return true;
    }
}