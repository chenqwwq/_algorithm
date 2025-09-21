package top.chenqwwq.leetcode.contest.biweek._77._1;

/**
 * @author chenqwwq
 * @date 2022/4/30
 **/
public class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if(s.indexOf(word) == 0){
                ans++;
            }
        }
        return ans;
    }
}