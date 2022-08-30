package top.chenqwwq.leetcode.biweek._85._2;

/**
 * @author chenqwwq
 * @date 2022/8/20
 **/
public class Solution {
    public int secondsToRemoveOccurrences(String s) {
        final int n = s.length();
        int cnt0 = 0;
        int first0 = -1,last1 = -1;
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            if(c == '0'){
                cnt0++;
                if(first0 == -1){
                    first0 = i;
                }
            }else{
                last1 = i;
            }
        }
        return -1;
    }
}