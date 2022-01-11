package top.chenqwwq.leetcode.biweek._49._1;

/**
 * @author chen
 * @date 2021/4/3
 **/
public class Solution {

    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a' + coordinates.charAt(1) - '0') & 1) == 0;
    }
}
