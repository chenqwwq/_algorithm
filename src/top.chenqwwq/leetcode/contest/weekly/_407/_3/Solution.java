package top.chenqwwq.leetcode.contest.weekly._407._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/7/21
 **/
public class Solution {
    public int maxOperations(String s) {
        final int n = s.length();
        int ans = 0, i = 0, cur = 0;
        List<Integer> nums = new ArrayList<>();
        while (i < n) {
            if (s.charAt(i) == '1') cur++;
            else if (cur > 0) {
                nums.add(cur);
                cur = 0;
            }
            i++;
        }
        int len = 0;
        for (int num : nums) {
            len += num;
            ans += len;
        }
        return ans;
    }
}