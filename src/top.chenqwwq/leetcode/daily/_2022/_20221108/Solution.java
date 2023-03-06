package top.chenqwwq.leetcode.daily._2022._20221108;

/**
 * @author chenqwwq
 * @date 2022/11/8
 **/
public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0,mask = getMask(allowed);
        for(String word : words){
            int m = getMask(word);
            if((m & mask) == m){
                ans++;
            }
        }
        return ans;
    }

    private int getMask(String word){
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            mask |= (1 << (word.charAt(i) - 'a'));
        }
        return mask;
    }
}