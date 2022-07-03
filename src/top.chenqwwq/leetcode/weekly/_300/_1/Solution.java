package top.chenqwwq.leetcode.weekly._300._1;

/**
 * @author chenqwwq
 * @date 2022/7/3
 **/
public class Solution {
    public String decodeMessage(String key, String message) {
        int[] hash = new int[26];
        for (int i = 0,j = 0; i < key.length(); i++) {
            final char c = key.charAt(i);
            if (c == ' ' || hash[c - 'a'] != 0) {
                continue;
            }
            hash[c - 'a'] = 'a' + j++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if(c == ' '){
                ans.append(c);
            }else {
                ans.append((char) (hash[c - 'a']));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        new Solution().decodeMessage("the quick brown fox jumps over the lazy dog"
               , "vkbs bs t suepuv");
    }
}