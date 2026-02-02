package top.chenqwwq.leetcode.pros.interview1618;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2025/12/13
 **/
public class Solution {


    public boolean patternMatching(String pattern, String value) {
        return dfs(value, pattern, 0, 0, new HashMap<>(), new HashSet<>());
    }

    public boolean dfs(String p, String v, int x, int y, Map<Character, String> memo, Set<String> vis) {
        if (x >= p.length() && y >= v.length()) return true;
        if (x >= p.length() || y >= v.length()) return false;

        char cc = v.charAt(y);
        if (memo.containsKey(cc)) {
            String s = memo.get(cc);
            for (int i = 0; i < s.length(); i++) {
                if (x + i >= p.length() || p.charAt(x + i) != s.charAt(i)) return false;
            }
            return dfs(p, v, x + s.length(), y + 1, memo, vis);
        }

        // 枚举当前的映射
        for (int i = 0; i + x <= p.length(); i++) {
            String s = p.substring(x, x + i);
            if (vis.contains(s)) continue;
            memo.put(cc, s);
            vis.add(s);
            if (dfs(p, v, x + i, y + 1, memo, vis)) {
                return true;
            }
            vis.remove(s);
            memo.remove(cc);

        }
        return true;
    }
}