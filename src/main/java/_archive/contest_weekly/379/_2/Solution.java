package top.chenqwwq.leetcode.contest.weekly._379._2;

/**
 * @author chenqwwq
 * @date 2024/1/7
 **/
public class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // 分类讨论
        // 1步的情况
        if (a == e && (a != c || ((d > b && d > f) || (d < b && d < f)))) return 1;
        if (b == f && (b != d || ((c > a && c > e) || (c < a && c < e)))) return 1;
        if (c - d == e - f && ((c - d != a - b) || ((a < c && a < e) || (a > c && a > e)))) return 1;
        if (c + d == e + f && (a + b != c + d || ((a < c && a < e) || (a > c && a > e)))) return 1;
        return 2;
    }
}