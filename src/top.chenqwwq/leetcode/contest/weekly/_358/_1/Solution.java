package top.chenqwwq.leetcode.contest.weekly._358._1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/8/13
 **/
public class Solution {
    Map<Integer, int[]> map;

    public int maxSum(int[] nums) {
        map = new HashMap<>();
        for (int num : nums) {
            final int max = getMax(num);
            final int[] ns = map.getOrDefault(max, new int[]{-1, -1});
            if (ns[0] <= num) {
                ns[1] = ns[0];
                ns[0] = num;
            } else if (ns[1] < num) {
                ns[1] = num;
            }
            map.put(max,ns);
        }

        int ans = -1;
        for (int[] ns : map.values()) {
            if (ns[1] == -1) continue;
            ;
            ans = Math.max(ans, ns[0] + ns[1]);
        }
        return ans;
    }

    private int getMax(int num) {
        int ret = 0;
        while (num != 0) {
            ret = Math.max(ret, num % 10);
            num /= 10;
        }
        return ret;
    }
}