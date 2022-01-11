package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/29 11:06
 */
public class LeetCode860 {
    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int fiveNum = 0, tenNum = 0;
            for (int bill : bills) {
                if (bill == 5) {
                    fiveNum++;
                }
                if (bill == 10) {
                    fiveNum--;
                    tenNum++;
                }
                if (bill == 20) {
                    if (tenNum > 0) {
                        tenNum--;
                        fiveNum--;
                    } else {
                        fiveNum -= 3;
                    }
                }

                if (fiveNum < 0 || tenNum < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
