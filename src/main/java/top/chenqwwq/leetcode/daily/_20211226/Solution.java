package top.chenqwwq.leetcode.daily._20211226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author chenbingxin
 * @date 2021/12/26
 **/
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        final String[] ss = text.split(" ");
        final int n = ss.length;
        if(n < 3){
            return new String[]{};
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if(first.equals(ss[i]) && second.equals(ss[i+1])){
                ans.add(ss[i+2]);
            }
        }
        return ans.toArray(new String[0]);
    }
}