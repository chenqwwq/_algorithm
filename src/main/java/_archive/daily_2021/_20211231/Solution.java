package top.chenqwwq.leetcode.daily._2021._20211231;

/**
 * @author chenbingxin
 * @date 2021/12/31
 **/
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num < 2){
            return false;
        }
        int sum = 1;
        for (int i = 2; i < num / i; i++) {
            if (num % i == 0) {
                sum = sum + i + num / i;
            }
        }
        return sum == num;
    }
}
