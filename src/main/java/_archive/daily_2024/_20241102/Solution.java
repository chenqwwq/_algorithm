package top.chenqwwq.leetcode.daily._2024._20241102;

/**
 * @author chenqwwq
 * @date 2024/11/2
 **/
public class Solution {
    public int minChanges(int n, int k) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int a = (n >> i) & 1, b = (k >> i) & 1;
            if (a == b) continue;
            if(a == 1) cnt++;
            else return -1;
        }
        return cnt;
    }
}