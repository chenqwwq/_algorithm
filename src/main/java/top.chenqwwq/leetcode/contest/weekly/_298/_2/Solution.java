package top.chenqwwq.leetcode.contest.weekly._298._2;

/**
 * @author chenqwwq
 * @date 2022/6/19
 **/
public class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0){
            return 0;
        }
        if (num < k) {
            return -1;
        }
        int n = num % 10;
        for (int i = 1; i < 10; i++) {
            if (n == (i * k) % 10 && i * k <= num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().minimumNumbers(58,9);
    }
}