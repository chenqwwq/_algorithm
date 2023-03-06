package top.chenqwwq.leetcode.daily._2022._20220806;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/8/6
 **/
public class Solution {
    public List<String> stringMatching(String[] words) {
        final int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> ans = new ArrayList<>();
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}