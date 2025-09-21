package top.chenqwwq.leetcode.contest.weekly._370._2;

/**
 * @author chenqwwq
 * @date 2023/11/9
 **/
public class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] d = new int[n];
        for (int[] edge : edges) d[edge[1]]++;
        int ans = -1;
        for (int i = 0;i < n;i++) {
            if(d[i] == 0){
                if(ans != -1) return -1;
                ans = i;
            }
        }
        return ans;
    }
}