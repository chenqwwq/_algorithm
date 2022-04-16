package top.chenqwwq.leetcode.biweek._76._2;

/**
 * @author chenqwwq
 * @date 2022/4/16
 **/
public class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int i = 0; i <= total / cost1; i++) {
            ans += ((total - cost1 * i) / cost2) + 1;
        }
        return ans;
    }
}