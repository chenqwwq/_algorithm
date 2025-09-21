package top.chenqwwq.leetcode.contest.biweek._93._1;

/**
 * @author chenqwwq
 * @date 2022/12/13
 **/
public class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;
        for(String str : strs){
            boolean flag = false;
            for(int i = 0;i < str.length();i++){
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'b'){
                    flag = true;
                    break;
                }
            }
            max = Math.max(max,flag ? str.length() : Integer.parseInt(str));
        }
        return max;
    }
}
