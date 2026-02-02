package top.chenqwwq.leetcode.contest.weekly._479._1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2025/12/7
 **/
public class Solution {
    public int[] sortByReflection(int[] nums) {
        return Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                final int x = get(o1);
                final int y = get(o2);
                if (x == y) return Integer.compare(o1, o2);
                return Integer.compare(x, y);
            }
        }).mapToInt(Integer::intValue).toArray();
    }

    private int get(Integer num) {
        final String bs = Integer.toBinaryString(num);
        int cur = 0, base = 1;
        for (int i = 0; i < bs.length(); i++) {
            cur += (bs.charAt(i) - '0') * base;
            base <<= 1;
        }
        return cur;
    }

}