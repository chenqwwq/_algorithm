package top.chenqwwq.leetcode.contest.weekly._351._4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 沽酒
 * @since 2023/06/25
 */
public class Solution {

    class Robot {
        int i;
        int position, health;
        char dir;


        public Robot(int i, int position, int health, char dir) {
            this.i = i;
            this.position = position;
            this.health = health;
            this.dir = dir;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        final int n = positions.length;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }
        Arrays.sort(robots, Comparator.comparingInt(o -> o.position));

        Robot[] stack = new Robot[n];
        int cur = -1;
        for (int i = 0; i < n; i++) {
            if (cur == -1 || !crash(stack[cur].dir, robots[i].dir)) {
                stack[++cur] = robots[i];
                continue;
            }
            // 发生碰撞
            while (cur != -1 && robots[i] != null && crash(stack[cur].dir, robots[i].dir)) {
                if (stack[cur].health < robots[i].health) {
                    cur--;
                    robots[i].health--;
                } else if (stack[cur].health > robots[i].health) {
                    robots[i] = null;
                    stack[cur].health--;
                } else {
                    cur--;
                    robots[i] = null;
                }
            }
            if (robots[i] != null) stack[++cur] = robots[i];
        }

        List<Robot> ans = new ArrayList<>();
        for (int i = 0; i <= cur; i++) ans.add(stack[i]);
        ans.sort(Comparator.comparingInt(o -> o.i));
        return ans.stream().map(o -> o.health).collect(Collectors.toList());
    }

    public boolean crash(char a, char b) {
        return a == 'R' && b == 'L';
    }
}