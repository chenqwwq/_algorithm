package top.chenqwwq.leetcode.contest.biweek._80._3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/6/11
 **/
public class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int n = s.length(), m = sub.length();
        Map<Character, Set<Character>> mmap = new HashMap<>();
        for (char[] cc : mappings) {
            Set<Character> set = mmap.getOrDefault(cc[0], new HashSet<>());
            set.add(cc[1]);
            mmap.put(cc[0], set);
        }

        char[] a = s.toCharArray(), b = sub.toCharArray();
        outer:
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0, k = i; j < m; j++, k++) {
                if (b[j] == a[k] || mmap.getOrDefault(b[j], new HashSet<>()).contains(a[k])) {
                    continue;
                }
                continue outer;
            }
            return true;
        }
        return false;
    }

}