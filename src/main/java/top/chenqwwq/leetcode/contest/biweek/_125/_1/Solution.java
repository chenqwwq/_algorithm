package top.chenqwwq.leetcode.contest.biweek._125._1;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/3/2
 **/
public class Solution {
    public int minOperations(int[] nums, int k) {
        if (nums == null) return 0;
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++){
           if(nums[i] >= k) return i;
        }
        return nums.length;
    }
}