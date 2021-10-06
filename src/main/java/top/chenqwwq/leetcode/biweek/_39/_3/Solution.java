package top.chenqwwq.leetcode.biweek._39._3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chen
 * @date 2020/11/14
 **/
public class Solution {
    int MAXN = 10000 + 50;
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> fb = new HashSet<>();
        for (int i : forbidden) {
            fb.add(i);
        }

        Set<Integer> path = new HashSet<>();
        return handle(fb, path, 0, x, false, a, b) ? path.size() : -1;
    }

    public boolean handle(Set<Integer> fb, Set<Integer> path, int curr, int x, boolean isBack, int a, int b) {
        if (curr == x) {
            return true;
        }
        if (curr < 0 || curr >= 10000+50 || path.contains(curr) || fb.contains(curr)) {
            return false;
        }

        path.add(curr);

        // 之前退后，现在只能往前
        if (isBack) {
            boolean handle = handle(fb, path, curr + a, x, false, a, b);
            if (!handle) {
                path.remove(curr);
            }
            return handle;
        }

        // 可前可后
        boolean b1 = handle(fb, path, curr + a, x, false, a, b) || handle(fb, path, curr - b, x, true, a, b);
        if (!b1) {
            path.remove(curr);
        }
        return b1;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumJumps(new int[]{128, 178, 147, 165, 63, 11, 150, 20, 158, 144, 136},
                61,
                170,
                135));
    }
}