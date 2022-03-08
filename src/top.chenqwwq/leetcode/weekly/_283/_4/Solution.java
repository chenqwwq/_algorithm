package top.chenqwwq.leetcode.weekly._283._4;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/3/6
 **/
public class Solution {


    int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a < b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        int mask = a | (b << 18);
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        int t;
        while (b != 0) {
            t = a % b;
            a = b;
            b = t;
        }
        memo.put(mask, a);
        return a;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int curr = nums[0];
        for (int i = 1;i < n;i++){
            int g = gcd(curr, nums[i]);
            if(g > 1){
                curr = curr * nums[i] / g;
            }else{
                ans.add(curr);
                curr = nums[++i];
            }
        }
        ans.add(curr);
        return ans;
    }

    Map<Integer, Integer> memo = new HashMap<>();
}