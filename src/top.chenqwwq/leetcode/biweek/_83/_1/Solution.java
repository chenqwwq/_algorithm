package top.chenqwwq.leetcode.biweek._83._1;

/**
 * @author chenqwwq
 * @date 2022/7/23
 **/
public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] cnt = new int[14], sc = new int[5];
        for (int rank : ranks) {
            cnt[rank]++;
        }
        for (char suit : suits) {
            sc[suit - 'a']++;
        }
        for (int num : sc) {
            if (num == 5) {
                return "Flush";
            }
        }
        for (int num : cnt) {
            if (num >= 3) {
                return "Three of a Kind";
            }
            if (num >= 2) {
                return "Pair";
            }
        }
        return "High Card";
    }
}