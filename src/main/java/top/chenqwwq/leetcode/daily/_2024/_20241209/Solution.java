package top.chenqwwq.leetcode.daily._2024._20241209;

/**
 * @author chenqwwq
 * @date 2024/12/10
 **/
public class Solution {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a' + 1) + (coordinates.charAt(1) - '0')) % 2 == 1;

    }
}