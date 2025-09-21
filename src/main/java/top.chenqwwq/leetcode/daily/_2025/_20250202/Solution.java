package top.chenqwwq.leetcode.daily._2025._20250202;

/**
 * @author chenqwwq
 * @date 2025/2/5
 **/
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops == null || ops.length == 0) return n * m;
        int mx = Integer.MAX_VALUE, my = Integer.MAX_VALUE;
        for(int[] op : ops){
            mx = Math.min(mx,op[0]);
            my = Math.min(my,op[1]);
        }
        return mx * my;
    }
}