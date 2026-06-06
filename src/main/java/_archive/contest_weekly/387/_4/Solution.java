package top.chenqwwq.leetcode.contest.weekly._387._4;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author chenqwwq
 * @date 2024/3/3
 **/
public class Solution {
    public int[] resultArray(int[] nums) {
        final int n = nums.length;
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        TreeMap<Integer, Integer> m1 = new TreeMap<>(), m2 = new TreeMap<>();
        l1.add(nums[0]);
        m1.put(nums[0], m1.getOrDefault(nums[0], 0) + 1);
        l2.add(nums[1]);
        m2.put(nums[1], m2.getOrDefault(nums[1], 0) + 1);
        for (int i = 2; i < n; i++) {
            int num = nums[i];
            final int c1 = greaterCount(m1, num), c2 = greaterCount(m2, num);
            if (c1 > c2 || (c1 == c2 && l1.size() <= l2.size())) {
                l1.add(num);
                m1.put(num,m1.getOrDefault(num,0)+1);
            }else {
                l2.add(num);
                m2.put(num,m2.getOrDefault(num,0)+1);
            }
        }
        l1.addAll(l2);
        for(int i = 0;i < n;i++){
            nums[i]=l1.get(i);
        }
        return nums;
    }

    private int greaterCount(TreeMap<Integer, Integer> m1, int val) {
        int ans = 0;
        for (int c : m1.tailMap(val, false).values()) {
            ans += c;
        }
        return ans;
    }
}