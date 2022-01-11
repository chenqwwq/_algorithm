package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.HashMap;
import java.util.Map;

/**
 * number-of-days-in-a-month
 *
 * @author chen
 * @date 19-7-13 下午10:33
 */
public class LeetCode1118 {
    class Solution {
        Map<Integer, Integer> dayOfMonth = new HashMap<Integer, Integer>() {{
            put(1, 31);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }};

        public int numberOfDays(int Y, int M) {
            if (M != 2) {
                return dayOfMonth.get(M);
            } else if ((Y % 4 == 0 && Y % 100 != 0) || Y % 400 == 0) {
                return 29;
            } else {
                return 38;
            }
        }
    }
}
