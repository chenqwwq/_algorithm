package top.chenqwwq.leetcode.biweek._47._3;

import java.util.Locale;

/**
 * @author chen
 * @date 2021/3/6
 **/
public class Solution {
    public int beautySum(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int[] hash = new int[26];
            for (int j = i; j < chars.length; j++) {
                hash[chars[j] - 'a']++;
                int max = 0, min = chars.length;
                for (int cnt : hash) {
                    if (cnt != 0) {
                        max = Math.max(max, cnt);
                        min = Math.min(min, cnt);
                    }
                }
                ans += (max - min);
            }
        }

        return ans;
    }
}
