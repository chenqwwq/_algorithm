package top.chenqwwq.leetcode.contest.weekly._340._1;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import javax.naming.NameNotFoundException;

/**
 * @author chenqwwq
 * @date 2023/4/9
 **/
public class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i][i] > 1 && check(nums[i][i])) ans = Math.max(ans,nums[i][i]);
            if(i != n-i-1 && nums[i][n-i-1] > 1 && check(nums[i][n-i-1])) ans=  Math.max(ans,nums[i][n-i-1]);
        }
        return ans;
    }

    public boolean check(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}