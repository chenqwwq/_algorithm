package top.chenqwwq.leetcode.daily._2023._20230722;

/**
 * @author chenqwwq
 * @date 2023/7/22
 **/
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0, cnt10 = 0;
        for (int bill : bills) {
            if (bill == 5) cnt5++;
            else if (bill == 10) {
                if (cnt5 < 1) return false;
                cnt5--;
                cnt10++;
            } else {
                if (cnt10 > 0 && cnt5 > 0) {
                    cnt10--;
                    cnt5--;
                } else if (cnt5 >= 3) cnt5 -= 3;
                else return false;
            }
        }
        return true;
    }
}