package top.chenqwwq.leetcode.daily._2022._20220801;

/**
 * @author chenqwwq
 * @date 2022/8/1
 **/
public class Solution {
    public String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i < n;i++){
            ans.append('a');
        }
        if((n & 1) == 1){
            return ans.toString();
        }
        ans.setCharAt(ans.length()-1,'b');
        return ans.toString();
    }
}