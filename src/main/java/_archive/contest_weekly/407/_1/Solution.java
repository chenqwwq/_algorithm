package top.chenqwwq.leetcode.contest.weekly._407._1;

/**
 * @author chenqwwq
 * @date 2024/7/21
 **/
public class Solution {
    public int minChanges(int n, int k) {
        int ans = 0;
        while (n != 0 || k != 0) {
            int i = n & 1,j = k & 1;
            if(i != j){
                if(j == 1) return -1;
                ans++;
            }
            n >>= 1;
            k >>= 1;
        }
        return ans;
    }

}