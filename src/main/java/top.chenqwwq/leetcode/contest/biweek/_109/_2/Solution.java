package top.chenqwwq.leetcode.contest.biweek._109._2;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2023/7/22
 **/
public class Solution {

    Set<Character> ss = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

    public String sortVowels(String s) {
        final int n = s.length();
        List<Character> cl = new ArrayList<>();
        List<Integer> idxs = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            if (ss.contains(s.charAt(i))) {
                cl.add(s.charAt(i));
                idxs.add(i);
            }
        }

        cl.sort(Character::compare);
        for (int i = 0; i < cl.size(); i++) {
            sb.setCharAt(idxs.get(i), cl.get(i));
        }
        return sb.toString();
    }
}