package top.chenqwwq.leetcode.contest.weekly._234._3;

import java.util.HashMap;
import java.util.List;

/**
 * @author chen
 * @date 2021/3/28
 **/
public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hash = new HashMap<>();
        for (List<String> list : knowledge) {
            hash.put(list.get(0), list.get(1));
        }

        final char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                StringBuilder key = new StringBuilder();
                while (chars[++i] != ')') {
                    key.append(chars[i]);
                }
                ans.append(hash.getOrDefault(key.toString(), "?"));
            } else {
                ans.append(chars[i]);
            }
        }

        return ans.toString();
    }
}
