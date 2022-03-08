package top.chenqwwq.leetcode.weekly._283;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/3/6
 **/
public class Solution {
    public List<String> cellsInRange(String s) {
        String[] ss = s.split(":");
        int a = ss[0].charAt(0), b = Integer.parseInt(ss[0].substring(1)), c = ss[1].charAt(0), d = Integer.parseInt(ss[1].substring(1));
        List<String> ans = new ArrayList<>();
        for (int i = a; i <= c; i++) {
            for (int j = b; j <= d; j++) {
               ans.add("" + (char)i + j);
            }
        }
        return ans;
    }
}