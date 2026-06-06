package top.chenqwwq.leetcode.contest.weekly._232._2;

/**
 * @author chen
 * @date 2021/3/14
 **/
public class Solution {
    public int findCenter(int[][] edges) {
        int a = edges[0][0],b = edges[0][1];
        return  edges[1][0] == a || edges[1][1] == a ? a : b;
    }
}