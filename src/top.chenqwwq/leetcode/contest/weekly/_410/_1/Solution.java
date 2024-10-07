package top.chenqwwq.leetcode.contest.weekly._410._1;

import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/8/11
 **/
public class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;
        for (String command : commands) {
            switch (command) {
                case "UP":
                    x--;
                    break;
                case "DOWN":
                    x++;
                    break;
                case "LEFT":
                    y--;
                    break;
                default:
                    y++;
                    break;
            }
        }
        return x * n + y;
    }
}