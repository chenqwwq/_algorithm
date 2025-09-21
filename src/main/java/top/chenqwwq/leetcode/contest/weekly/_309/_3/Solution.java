package top.chenqwwq.leetcode.contest.weekly._309._3;

/**
 * @author chenqwwq
 * @date 2022/9/4
 **/
public class Solution {
    public int longestNiceSubarray(int[] nums) {
        final int n = nums.length;
        int ans = 1;
        int[] cnt = new int[32];
        int l = 0, r = 0;
        while (r < n) {
            boolean ok = true;
            for (int i = 0; i < 32; i++) {
                if ((cnt[i] += (nums[r] >> i) & 1) > 1) {
                    ok = false;
                }
            }
           if(ok){
               ans = Math.max(ans,r - l + 1);
           } else {
               while (!ok){
                   boolean success = true;
                   for (int i = 0; i < 32; i++) {
                       if ((cnt[i] -= (nums[l] >> i) & 1) > 1) {
                           success = false;
                       }
                   }
                   ok = success;
                   l++;
               }
           }
            r++;
        }
        return ans;
    }


    public static void main(String[] args) {
        new Solution().longestNiceSubarray(new int[]{1, 3, 8, 48, 10});
    }
}