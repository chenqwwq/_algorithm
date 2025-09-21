package top.chenqwwq.leetcode.contest.weekly._408._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/7/28
 **/
public class Solution {
    public int numberOfSubstrings(String s) {
        final int n = s.length();
        List<Integer> nums = new ArrayList<>();
        int cnt = 0, cur = -1;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            if (cur != num) {
                if (cnt != 0) nums.add(cnt);
                cur = s.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        return 1;
    }
}