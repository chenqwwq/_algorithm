package top.chenqwwq.leetcode.weekly._290._1;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/4/24
 **/
public class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < nums[0].length; i++) {
            s1.add(nums[0][i]);
        }
        for (int i = 1; i < n; i++) {
            Set<Integer> s2 = new HashSet<>();
            for (int j = 0; j < nums[i].length; j++) {
                s2.add(nums[i][j]);
            }
            s1.retainAll(s2);
        }
        ArrayList<Integer> ans = new ArrayList<>(s1);
        Collections.sort(ans);
        return ans;
    }
}