package top.chenqwwq.leetcode.daily._20220425;

import java.util.Random;

/**
 * @author chenqwwq
 * @date 2022/4/25
 **/
public class Solution {

    int[] nums;
    Random random;


    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int ans = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (random.nextInt(++cnt) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}
