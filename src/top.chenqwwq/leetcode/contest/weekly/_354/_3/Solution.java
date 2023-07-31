package top.chenqwwq.leetcode.contest.weekly._354._3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/7/16
 **/
public class Solution {
    public int minimumIndex(List<Integer> nums) {
        final int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);
        int num = -1, cnt = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > cnt) {
                cnt = entry.getValue();
                num = entry.getKey();
            }
        }

        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == num) {
                cur++;
                cnt--;
            }
            if (cur * 2 > i + 1 && cnt * 2 > n - i - 1) return i;
        }
        return -1;
    }
}