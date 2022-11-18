package top.chenqwwq.leetcode.daily._20221117;

import top.chenqwwq.leetcode.common.Node;
import top.chenqwwq.leetcode.contest.biweek._28._2.SubrectangleQueries;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author chenqwwq
 * @date 2022/11/17
 **/
public class Solution {

    Map<Character, TreeSet<Integer>> map;

    public int numMatchingSubseq(String s, String[] words) {
        this.map = new HashMap<>();
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, new TreeSet<>());
            map.get(c).add(i);
        }
        int cnt = 0;
        for (String word : words) {
            if (check(word)) cnt++;
        }
        return cnt;
    }

    public boolean check(String word) {
        int p = -1;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            TreeSet<Integer> set = map.get(c);
            if (set == null) return false;
            Integer d = set.higher(p);
            if(d == null) return false;
            p = d;
        }
        return true;
    }
}