package top.chenqwwq.leetcode.contest.weekly._483._2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2026/1/5
 **/
public class Solution {
    public List<List<String>> wordSquares(String[] words) {

        List<List<String>> ans = new ArrayList<>();
        dfs(words, ans, new String[4], 0);
        ans.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                for (int i = 0; i < 4; i++) {
                    if (Objects.equals(o1.get(i), o2.get(i))) {
                        continue;
                    }
                    return o1.get(i).compareTo(o2.get(i));
                }
                return 0;
            }
        });
        return ans;
    }

    public void dfs(String[] words, List<List<String>> ans, String[] cur, int idx) {
        if (idx >= 4) {
            if (check(cur[0], cur[1], cur[2], cur[3])) {
                List<String> list = new ArrayList<>();
                list.add(cur[0]);
                list.add(cur[1]);
                list.add(cur[2]);
                list.add(cur[3]);
                ans.add(list);
            }
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) continue;
            cur[idx] = words[i];
            words[i] = null;
            dfs(words, ans, cur, idx + 1);
            words[i] = cur[idx];
        }
    }

    public boolean check(String top, String left, String right, String bottom) {
        return top.charAt(0) == left.charAt(0) && top.charAt(3) == right.charAt(0) && bottom.charAt(0) == left.charAt(3) && bottom.charAt(3) == right.charAt(3);
    }
}