package top.chenqwwq.leetcode.contest.weekly._338._1;

/**
 * @author chenqwwq
 * @date 2023/4/5
 **/
public class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k <= numOnes) return k;
        if(k - numOnes <= numZeros) return numOnes;
        return numOnes - (k - numOnes - numZeros);
    }
}