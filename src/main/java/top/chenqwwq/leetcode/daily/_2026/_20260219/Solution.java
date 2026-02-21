package top.chenqwwq.leetcode.daily._2026._20260219;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/2/19
 **/
public class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> cs = new ArrayList<>();
        int cur = '0', cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == cur) {
                cnt++;
            } else {
                if (cnt != 0) cs.add(cnt);
                cnt = 1;
                cur = c;
            }
        }
        if (cnt != 0) cs.add(cnt);
        int ans = 0;
        for (int i = 0; i < cs.size() - 1; i++) {
            int min = Math.min(cs.get(i), cs.get(i + 1));
            ans += min;
        }
        return ans;
    }
}