package top.chenqwwq.leetcode.topic.random._398;

import java.util.*;

/**
 * @author 沽酒
 * @since 2023/06/13
 */
public class Solution {

    // 直接使用 Map 保存 Value - Index List 的保存索引下标
    // 可以直接食用随机数 API
    // 为了学习蓄水池抽样,写一遍

    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int ans = -1,cnt = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != target) continue;
            if(random.nextInt(++cnt) == 0) ans = i;
        }
        return ans;
    }
}
