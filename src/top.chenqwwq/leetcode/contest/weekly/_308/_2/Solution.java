package top.chenqwwq.leetcode.contest.weekly._308._2;

/**
 * @author chenqwwq
 * @date 2022/8/28
 **/
public class Solution {
    public String removeStars(String s) {
        final int n = s.length();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = n-1;i >= 0;i--){
            if(s.charAt(i) == '*'){
                cnt++;
            }else {
                if (cnt > 0){
                    cnt--;
                }else {
                    sb.insert(0, s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
