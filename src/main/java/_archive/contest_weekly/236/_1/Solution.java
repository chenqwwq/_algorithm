package top.chenqwwq.leetcode.contest.weekly._236._1;

/**
 * @author chen
 * @date 2021/4/11
 **/
public class Solution {
    public int arraySign(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i : nums) {
            if (i == 0) {
                return 0;
            }
            if (i < 0) {
                cnt++;
            }
        }

        return (cnt & 1) == 1 ? -1 : 1;
    }
}
