package top.chenqwwq.leetcode.daily._2025._20250301;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/3/1
 **/
public class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(new ArrayList<>(), s, 0, 0);
        return ans;
    }

    public void dfs(List<String> cur, String s, int l, int r) {
        if (r >= s.length()) {
            if (l == r) {
                ans.add(List.copyOf(cur));
            }
            // 到末尾了单独处理
            return;
        }


        // 是不是回文都和后面拼接
        dfs(cur, s, l, r + 1);
        // l->r已经是一个回文了
        if (check(s, l, r)) {
            cur.add(s.substring(l, r + 1));
            dfs(cur, s, r + 1, r + 1);
            cur.remove(cur.size() - 1);
        }

    }

    public boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}