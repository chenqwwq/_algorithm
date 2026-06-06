package top.chenqwwq.leetcode.contest.biweek._90._2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author chenqwwq
 * @date 2022/10/31
 **/
public class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String query : queries){
            for(String dic : dictionary){
                if(compare(query,dic)){
                    ans.add(query);
                    break;
                }
            }
        }
        return ans;
    }

    public boolean compare(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && ++cnt > 2) {
                return false;
            }
        }
        return true;
    }
}