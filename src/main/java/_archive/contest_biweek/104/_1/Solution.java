package top.chenqwwq.leetcode.contest.biweek._104._1;

/**
 * @author 沽酒
 * @since 2023/05/17
 */
public class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String detail : details) {
            int age = (detail.charAt(11) - '0') * 10 + detail.charAt(12) - '0';
            if(age > 60) cnt++;
        }
        return cnt;
    }
}
