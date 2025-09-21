package top.chenqwwq.leetcode.daily._2022._20220613;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/6/13
 **/
public class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] exc = new int[n];
        System.arraycopy(heights, 0, exc, 0, n);
        Arrays.sort(exc);
        int ans = 0;
        for (int i = 0;i < n;i++){
            if(heights[i] != exc[i]){
                ans++;
            }
        }
        return ans;
    }
}