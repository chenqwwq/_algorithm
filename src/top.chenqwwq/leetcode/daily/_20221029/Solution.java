package top.chenqwwq.leetcode.daily._20221029;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/10/29
 **/
public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int p = 0;
        if (Objects.equals(ruleKey, "type")) p = 0;
        else if (Objects.equals(ruleKey, "color")) p = 1;
        else p = 2;

        int ans = 0;
        for (List<String> item : items){
            if (Objects.equals(item.get(p), ruleValue)) ans++;
        }
        return ans;
    }
}