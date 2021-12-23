package top.chenqwwq.leetcode.weekly._123._2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chen
 * @date 2020/11/15
 **/
public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) {
            return false;
        }

        int[] hash = new int[26];
        for (char c : word1.toCharArray()) {
            hash[c - 'a']++;
        }

        int[] hash1 = new int[26];
        for (char c : word2.toCharArray()) {
            hash1[c - 'a']++;
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (hash[i] == hash1[i]) {
                hash[i] = hash1[i] = 0;
            } else if (hash[i] == 0 || hash1[i] == 0) {
                return false;
            } else {
                set.add(hash[i]);
                set1.add(hash1[i]);
            }
        }


        for (int i : set) {
            if (!set1.contains(i)) {
                return false;
            }
        }

        return true;
    }
}