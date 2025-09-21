package top.chenqwwq.leetcode.contest.biweek._107._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/6/24
 **/
public class Solution {
    public int longestString(int x, int y, int z) {
        if (x > y) return (2 * y + 1 + z) * 2;
        else if (x == y) return (x + y + z) * 2;
        else return (2 * x + 1 + z) * 2;

    }
}