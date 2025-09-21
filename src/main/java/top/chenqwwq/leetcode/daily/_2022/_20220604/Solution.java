package top.chenqwwq.leetcode.daily._2022._20220604;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/6/4
 **/
public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<>();
        for (String email : emails) {
            ans.add(handle(email));
        }
        return ans.size();
    }

    private String handle(String e) {
        String[] ee = e.split("@");
        int pos = ee[0].indexOf("+");
        if (pos != -1) {
            ee[0] = ee[0].substring(0, pos);
        }
        ee[0] = ee[0].replace(".", "");
        return ee[0] + "@" + ee[1];
    }
}