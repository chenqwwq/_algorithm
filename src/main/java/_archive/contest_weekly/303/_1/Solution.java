package top.chenqwwq.leetcode.contest.weekly._303._1;

/**
 * @author chenqwwq
 * @date 2022/7/24
 **/
public class Solution {
    public char repeatedCharacter(String s) {
        int[] hash = new int[26];
        for(char c : s.toCharArray()){
            if(++hash[c-'a'] >= 2){
                return c;
            }
        }
        return 'a';
    }
}