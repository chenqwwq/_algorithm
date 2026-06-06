package top.chenqwwq.leetcode.contest.weekly._416._1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2024/9/22
 **/
public class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        final Set<String> bws = new HashSet<>(Arrays.asList(bannedWords));
        int cnt = 0;
        for(String s : message){
            if(bws.contains(s)){
                if(++cnt >= 2) return true;
            }
        }
        return false;
    }
}