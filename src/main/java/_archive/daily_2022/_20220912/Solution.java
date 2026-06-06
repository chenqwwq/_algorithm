package top.chenqwwq.leetcode.daily._2022._20220912;

/**
 * @author chenqwwq
 * @date 2022/9/13
 **/
public class Solution {
    public int specialArray(int[] nums) {
        int[] cnts = new int[1010];
        for (int x : nums) cnts[x]++;
        for (int i = 1009, tot = 0; i >= 0; i--) {
            tot += cnts[i];
            if (i == tot) return i;
        }
        return -1;
    }
}
