package top.chenqwwq.leetcode.contest.weekly._379._3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2024/1/7
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().maximumSetSize(new int[]{7, 8, 9, 10}, new int[]{5, 7, 9, 9});
    }

    public int maximumSetSize(int[] nums1, int[] nums2) {
        final int n = nums1.length, m = n >> 1;
        final Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        for (int num : nums1) s1.add(num);
        for (int num : nums2) s2.add(num);
        final Set<Integer> common = new HashSet<>();
        for (int num : s1) if (s2.contains(num)) common.add(num);
        int cnt = common.size();
        int ans = s1.size() + s2.size() - cnt;
        if (s1.size() > m) ans -= Math.max(0, s1.size() - m - cnt);
        cnt -= s1.size() - m - cnt;
        if (s2.size() > m) ans -= Math.max(0, s2.size() - m - cnt);
        return ans;
    }
}