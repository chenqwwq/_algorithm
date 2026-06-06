package top.chenqwwq.leetcode.daily._2025._20251020;

/**
 * @author chenqwwq
 * @date 2025/10/20
 **/
public class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String s : operations) {
            if (s.contains("++")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}