package top.chenqwwq.leetcode.daily._2023._20230719;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2023/7/19
 **/
public class Solution {

    int[][] m = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    private int key(int a, int b) {
        return a * 60001 + b;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        final Set<Integer> obstacle = new HashSet<>();
        for (var ob : obstacles) obstacle.add(key(ob[0], ob[1]));
        int ans = 0;
        int x = 0, y = 0, d = 3;
        for (var command : commands) {
            if (command < 0) {
                d += (command == -1 ? 1 : -1);
                d = (d + 4) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int xx = x + m[d][0], yy = y + m[d][1];
                    if (obstacle.contains(key(xx,yy))) break;
                    x = xx;
                    y = yy;
                }
                ans = Math.max(ans, x * x + y * y);
            }
        }
        return ans;
    }
}