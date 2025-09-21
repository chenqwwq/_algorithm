package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description 二进制手表的读数，n表示亮着的指示灯数量
 * @email chenbxxx@gmail.con
 * @date 2019/2/28 14:40
 */
public class LeetCode401 {
    public static void main(String[] args) {
        new LeetCode401().new Solution().readBinaryWatch(1);
    }

    class Solution {
        private List<String> res = new ArrayList<>();

        public List<String> readBinaryWatch(int num) {
            dfs(0, 0, num, 0);
            return res;
        }

        private void dfs(int time, int pos, int num, int index) {
            if (pos == num) {
                handle(time);
                return;
            }
            for (int i = index; i < 10; i++) {
                if ((time & 1 << i) == 0) {
                    dfs(time | 1 << i, pos + 1, num, i);
                }
            }
        }

        private void handle(int time) {
            // 计算小时
            final int hour = time >> 6;
            if (hour > 11) {
                return;
            }
            // 将低8位置0,再异或
            final int minute = time & 960 ^ time;
            if (minute > 59) {
                return;
            }
            res.add(hour + ":" + (minute > 9 ? minute : "0" + minute));
        }
    }
}
