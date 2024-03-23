package top.chenqwwq.leetcode.contest.weekly._387._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/3/3
 **/
public class Solution {
    public int[] resultArray(int[] nums) {
        final int n = nums.length;
        List<Integer> l1 = new ArrayList<>(),l2 = new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        for(int i = 2;i < n;i++){
            if(l1.get(l1.size()-1) > l2.get(l2.size()-1)) l1.add(nums[i]);
            else l2.add(nums[i]);
        }
        l1.addAll(l2);
        for(int i = 0;i < n;i++){
            nums[i] = l1.get(i);
        }
        return nums;
    }
}