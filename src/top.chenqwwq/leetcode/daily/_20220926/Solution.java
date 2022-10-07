package top.chenqwwq.leetcode.daily._20220926;

/**
 * @author chenqwwq
 * @date 2022/9/26
 **/
public class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, cur = n * (1 + n) / 2;
        for (int x : nums) cur -= x;
        int sum = cur, t = cur / 2;
        cur = t * (1 + t) / 2;
        for (int x : nums) {
            if (x <= t) cur -= x;
        }
        return new int[]{cur, sum - cur};
    }
}