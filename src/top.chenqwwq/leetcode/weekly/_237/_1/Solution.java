package top.chenqwwq.leetcode.weekly._237._1;

/**
 * @author chen
 * @date 2021/4/18
 **/
public class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] hash = new boolean[26];
        int cnt = 0;
        for (char c : sentence.toCharArray()) {
            if (!hash[c - 'a']) {
                hash[c - 'a'] = true;
                cnt++;
            }
        }

        return cnt == 26;
    }
}
