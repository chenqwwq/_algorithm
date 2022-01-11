package top.chenqwwq.leetcode.biweek._47._2;

/**
 * @author chen
 * @date 2021/3/6
 **/
public class Solution {
    public boolean checkPowersOfThree(int n) {

        while (n != 1) {
            int i = n % 3, j = n / 3;
            if (i > 1) {
                return false;
            }
            n = j;
        }
        return true;
    }
}
