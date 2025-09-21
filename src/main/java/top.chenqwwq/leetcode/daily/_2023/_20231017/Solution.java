package top.chenqwwq.leetcode.daily._2023._20231017;

/**
 * @author chenqwwq
 * @date 2023/10/17
 **/
public class Solution {
    public int sumOfMultiples(int n) {
        int sum = 0;
        for(int i = 1;i <= n;i++){
            if(n % 3 == 0 || n % 5 == 0 || n % 7 == 0){
                sum += i;
            }
        }
        return sum;
    }
}