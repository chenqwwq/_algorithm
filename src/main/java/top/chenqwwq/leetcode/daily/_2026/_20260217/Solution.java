package top.chenqwwq.leetcode.daily._2026._20260217;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/2/18
 **/
public class Solution {

    int[] hours = new int[]{1, 2, 4, 8};
    int[] minutes = new int[]{1, 2, 4, 8, 16, 32};
    List<String> ans;

    public List<String> readBinaryWatch(int turnedOn) {
        ans = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, 10); i++) {
            if (Integer.bitCount(i) != turnedOn) continue;
            int h = 0, m = 0;
            for (int j = 0; j < 4; j++) {
                h += hours[j] * ((i >> (j + 6)) & 1);
            }
            for (int j = 4; j < 10; j++) {
                m += minutes[j] * ((i >> j) & 1);
            }
            if (h < 12 && m < 60) {
                ans.add(String.format("%d:%02d", h, m));
            }
        }
        return ans;
    }

}