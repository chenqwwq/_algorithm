package top.chenqwwq.leetcode.contest.weekly._302._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/7/17
 **/
public class Solution {
    int inf = 0x3f3f3f3f;

    private int getBitSum(int num) {
        int ret = 0;
        while (num != 0) {
            ret += (num % 10);
            num /= 10;
        }
        return ret;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            int bitSum = getBitSum(num);
            int[] a = map.getOrDefault(bitSum, new int[]{-inf, -inf});
            if (a[1] < num) {
                a[0] = a[1];
                a[1] = num;
            } else if (a[0] < num) {
                a[0] = num;
            }
            ans = Math.max(a[0] + a[1], ans);
            map.put(bitSum,a);
        }
        return ans;
    }
}