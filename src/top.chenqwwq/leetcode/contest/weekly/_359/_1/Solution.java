package top.chenqwwq.leetcode.contest.weekly._359._1;

import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/8/20
 **/
public class Solution {
    public boolean isAcronym(List<String> words, String s) {
        final int n = words.size();
        if(n != s.length()) return false;
        for(int i = 0;i < n;i++){
            if(s.charAt(i) != words.get(i).charAt(0)) return false;
        }
        return true;
    }
}