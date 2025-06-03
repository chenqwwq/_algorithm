package top.chenqwwq.leetcode.daily._2025._20250324;

/**
 * @author chenqwwq
 * @date 2025/3/24
 **/
public class Solution {
    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        outer:
        for (String word : words) {
            if (word.length() > s.length()) continue;
            for(int i = 0;i < word.length();i++){
                if(word.charAt(i) != s.charAt(i)){
                    continue outer;
                }
            }
            cnt++;
        }
        return cnt;
    }
}