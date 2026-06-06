package top.chenqwwq.leetcode.daily._2022._20221103;

/**
 * @author chenqwwq
 * @date 2022/11/3
 **/
public class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        String pattern = word;
        while(sequence.contains(pattern)){
            ans ++;
            pattern += word;
        }
        return ans;
    }
}