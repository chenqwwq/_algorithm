package top.chenqwwq.leetcode.daily._20220615;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/6/16
 **/
public class Solution {
    public int findPairs(int[] nums, int k) {
        final int n = nums.length;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.put(nums[i], i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(!hash.containsKey(nums[i])){
                continue;
            }
            if (hash.getOrDefault(nums[i] - k, 0) > i) {
                System.out.printf("%d %d\n", nums[i], nums[i] - k);
                ans++;
            }
            if (k != 0 && hash.getOrDefault(nums[i] + k, 0) > i) {
                System.out.printf("%d %d\n", nums[i], nums[i] + k);
                ans++;
            }
            hash.remove(nums[i]);
        }
        return ans;
    }
}