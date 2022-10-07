package top.chenqwwq.leetcode.contest.weekly._298._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/6/19
 **/
public class Solution {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (int i = 0; i < 26; i++) {
            char a = (char) ('Z' - i), b = (char) ('z' - i);
            if (set.contains(a) && set.contains(b)) {
                return "" + a;
            }
        }
        return "";
    }
}
