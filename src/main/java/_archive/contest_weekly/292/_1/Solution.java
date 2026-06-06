package top.chenqwwq.leetcode.contest.weekly._292._1;

/**
 * @author chenqwwq
 * @date 2022/5/8
 **/
public class Solution {
    public String largestGoodInteger(String num) {
        if (num.length() < 3) {
            return "";
        }
        int[] hash = new int[10];
        hash[num.charAt(0) - '0']++;
        hash[num.charAt(1) - '0']++;
        int target = -1;
        String ans = "";
        for (int i = 2; i < num.length(); i++) {
            if (++hash[num.charAt(i) - '0'] == 3) {
                String tmp = num.substring(i - 2, i + 1);
                int number = Integer.parseInt(tmp);
                if (number > target) {
                    ans = tmp;
                    target = number;
                }
            }
            --hash[num.charAt(i - 2) - '0'];
        }
        return ans;
    }
}
