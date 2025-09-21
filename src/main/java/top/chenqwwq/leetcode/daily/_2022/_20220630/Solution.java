package top.chenqwwq.leetcode.daily._2022._20220630;

/**
 * @author 沽酒
 * @date 2022/06/30
 */
public class Solution {
    int mod = (int) 1e9 + 7;

    public int numPrimeArrangements(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (is(i)) {
                cnt++;
            }
        }
        return (int) (factorial(cnt) * factorial(n - cnt) % mod);
    }

    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= mod;
        }
        return res;
    }


    private boolean is(int num) {
        if(num == 1){
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}