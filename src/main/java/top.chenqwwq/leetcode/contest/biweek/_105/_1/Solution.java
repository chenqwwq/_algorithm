package top.chenqwwq.leetcode.contest.biweek._105._1;

import java.util.Arrays;

/**
 * @author 沽酒
 * @since 2023/05/29
 */
public class Solution {
    public int buyChoco(int[] prices, int money) {
        int a = Integer.MAX_VALUE,b = Integer.MAX_VALUE;
        for(int price : prices){
            if(price < a){
                b = a;
                a = price;
            }else if(price < b){
                b = price;
            }
        }
        final int total = a + b ;
        return total > money ? money : money - total;
    }
}