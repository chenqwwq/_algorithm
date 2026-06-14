package top.chenqwwq.leetcode.daily._2026._20260613;

public class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        final  int n = words.length;
        char[] ret = new char[n];
        for(int i = 0;i < n;i++){
            int t = 0;
            for(char c : words[i].toCharArray()){
                t += weights[c-'a'];
            }
            ret[i] = (char)('z' - (t % 26));
        }
        return new String(ret);
    }
}