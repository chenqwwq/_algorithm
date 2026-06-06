package top.chenqwwq.leetcode.contest.biweek._78._1;

/**
 * @author chenqwwq
 * @date 2022/5/14
 **/
public class Solution {
    public int divisorSubstrings(int num, int k) {
        int ans = 0;
        String n = String.valueOf(num);
        for (int l = 0, r = k; r <= n.length(); l++, r++) {
            String ss = n.substring(l, r);
            int i = Integer.parseInt(ss);
            if (i == 0) {
                continue;
            }
            if(num % i == 0){
                ans++;
            }
        }
        return ans;
    }
}