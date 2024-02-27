package top.chenqwwq.leetcode.daily._2023._20231016;

/**
 * @author chenqwwq
 * @date 2023/10/17
 **/
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) xorsum ^= num;
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) type1 ^= num;
             else type2 ^= num;
        }
        return new int[]{type1, type2};
    }
}