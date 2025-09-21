package top.chenqwwq.leetcode.contest.biweek._68._1;

/**
 * @author chenbingxin
 * @date 2021/12/26
 **/
public class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for (String sentence : sentences){
            ans = Math.max(ans,sentence.split(" ").length);
        }
        return ans;
    }
}
