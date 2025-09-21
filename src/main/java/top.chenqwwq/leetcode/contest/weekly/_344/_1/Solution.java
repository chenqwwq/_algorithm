package top.chenqwwq.leetcode.contest.weekly._344._1;

/**
 * @author 沽酒
 * @since 2023/05/09
 */
public class Solution {

    final int N = 51;

    public int[] distinctDifferenceArray(int[] nums) {
        final int n = nums.length;
        int[] pre = new int[N], sub = new int[N];
        int front = 0, back = 0;
        for (int num : nums) {
            if(++sub[num] == 1) back++;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if(pre[nums[i]]++ == 0) front++;
            if(sub[nums[i]]-- == 1) back--;
            ans[i] = front - back;
        }
        return ans;
    }
}