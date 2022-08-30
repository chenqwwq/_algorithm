package top.chenqwwq.leetcode.daily._20220828;

/**
 * @author chenqwwq
 * @date 2022/8/28
 **/
public class Solution {
    public int preimageSizeFZF(int k) {
        return -1;
    }

    public static void main(String[] args) {
        System.out.println( 2 ^ 3 ^ 4 ^ 5);
    }
    int getCnt(int x){
        int ans = 0;
        while (x != 0) {
            ans += x / 5; x /= 5;
        }
        return ans;
    }
}