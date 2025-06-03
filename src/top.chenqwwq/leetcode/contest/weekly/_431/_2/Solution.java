package top.chenqwwq.leetcode.contest.weekly._431._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/1/5
 **/
public class Solution {

    List<Integer>[] hash = new List[26];

    {
        for (int i = 0; i < 26; i++) {
            hash[i] = new ArrayList<>();
        }
    }

    public long calculateScore(String s) {
        final int n = s.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            final int idx = s.charAt(i) - 'a', ridx = 26 - idx - 1;
            if (!hash[ridx].isEmpty()) {
                ans += i - hash[ridx].remove(hash[ridx].size() - 1);
            } else {
                hash[idx].add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().calculateScore("azapfwonwwcdagew");
    }
}