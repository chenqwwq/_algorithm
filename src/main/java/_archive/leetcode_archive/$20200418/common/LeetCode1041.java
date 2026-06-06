package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 1041. Robot Bounded In Circle 判断机器入是否在圈内
 *
 * @author chen
 * @date 19-5-12
 */
public class LeetCode1041 {
    class Solution {
        private static final char oneUnit = 'G';
        private static final char turnLeft = 'L';
        private static final char turnRight = 'R';

        public boolean isRobotBounded(String instructions) {
            if (instructions == null || instructions.length() == 0) {
                return true;
            }
            final char[] chars = instructions.toCharArray();
            int[] position = new int[]{0, 0};
            int direction = 0;
            for (char c : chars) {
                if (c == oneUnit) {
                    switch (direction) {
                        case 0:
                            position[1]++;
                            break;
                        case 1:
                            position[0]++;
                            break;
                        case 2:
                            position[1]--;
                            break;
                        case 3:
                            position[0]--;
                            break;
                        default:
                            break;
                    }
                } else if (c == turnRight) {
                    direction = Math.floorMod(direction + 1, 4);
                } else if (c == turnLeft) {
                    direction = Math.floorMod(direction + 3, 4);
                }
            }
            // 判断是否在一个圆里面的标志
            return position[0] == 0 && position[1] == 0 || direction > 0;
        }
    }
}
