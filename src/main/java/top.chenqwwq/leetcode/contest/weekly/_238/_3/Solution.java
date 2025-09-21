package top.chenqwwq.leetcode.contest.weekly._238._3;

/**
 * @author chen
 * @date 2021-04-25
 **/
public class Solution {
    int[] hash = new int[26];
    {
        hash[0] = 1;
        hash['e' - 'a'] = 2;
        hash['i' - 'a'] = 3;
        hash['o' - 'a'] = 4;
        hash['u' - 'a'] = 5;
    }

    public int longestBeautifulSubstring(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        final char[] chars = word.toCharArray();
        int ans = 0, currLen = 1, pre = hash[chars[0] - 'a'];
        int cnt = 1;
        for (int i = 1; i < word.length(); i++) {
            final int idx = chars[i] - 'a';
            int curr = hash[idx];
            if (curr < pre) {
                currLen = 1;
                pre = curr;
                cnt = 1;
            } else if (curr == pre) {
                currLen++;
            } else {
                currLen++;
                pre = curr;
                cnt++;
            }
            if (cnt == 5) {
                ans = Math.max(ans, currLen);
            }
        }
        return ans;
    }
}
