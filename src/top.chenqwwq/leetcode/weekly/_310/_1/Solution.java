package top.chenqwwq.leetcode.weekly._310._1;

/**
 * @author chenqwwq
 * @date 2022/9/11
 **/
public class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] hash = new int[10001];
        int ans = -1, cnt = 0;
        for (int num : nums) {
            hash[num]++;
            if ((num & 1) == 0) {
                if (hash[num] > cnt || (hash[num] == cnt && num < ans)) {
                    ans = num;
                    cnt = hash[num];
                }
            }
        }
        return ans;
    }
}