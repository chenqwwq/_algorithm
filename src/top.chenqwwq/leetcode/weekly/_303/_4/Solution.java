package top.chenqwwq.leetcode.weekly._303._4;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/7/24
 **/
public class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int[] cs = new int[32];
        for (int i = 0;i < nums.length;i++){
            int num = nums[i];
            if(i > 0 && num == nums[i-1]){
                continue;
            }
            cs[bitCnt(num)]++;
        }
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (i + j >= k) {
                    ans += ((long) cs[i] * cs[j]);
                }
            }
        }
        return ans;
    }

    private int bitCnt(int num) {
        int ans = 0;
        while (num != 0) {
            num &= (num - 1);
            ans++;
        }
        return ans;
    }
}
