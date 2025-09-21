package top.chenqwwq.leetcode.contest.weekly._212._1;

/**
 * @author chen
 * @date 2020/10/25
 **/
public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] hash = new int[26];
        hash[keysPressed.charAt(0) - 'a'] += releaseTimes[0];
        for (int i = 1; i < keysPressed.length(); i++) {
            int i1 = keysPressed.charAt(i) - 'a';
            hash[i1] = Math.max(hash[i1], releaseTimes[i] - releaseTimes[i - 1]);
        }

        int max = 0;
        int maxIdx = 0;

        for (int i = 0; i < 26; i++) {
            if (hash[i] >= max) {
                max = hash[i];
                maxIdx = i;
            }
        }

        return (char) ('a' + maxIdx);
    }
}