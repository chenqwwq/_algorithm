package top.chenqwwq.leetcode.daily._2023._20231025;

/**
 * @author chenqwwq
 * @date 2023/10/23
 **/
public class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for(String d : details) if((d.charAt(11) - '0') * 10 + (d.charAt(12) - '0') > 60) cnt++;
        return cnt;
    }
}