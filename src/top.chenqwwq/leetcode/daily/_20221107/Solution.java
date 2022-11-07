package top.chenqwwq.leetcode.daily._20221107;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/11/7
 **/
public class Solution {
    String s;
    int n;

    public List<String> ambiguousCoordinates(String s) {
        this.s = s;
        this.n = s.length();
        List<String> ans = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            List<String> b1 = backtrace(1, i);
            List<String> b2 = backtrace(i + 1, n - 2);
            for (String a : b1) {
                for (String b : b2) {
                    ans.add("(" + a + ", " + b + ")");
                }
            }
        }
        return ans;
    }

    private List<String> backtrace(int i, int j) {
        if (i == j) return List.of(String.valueOf(s.charAt(i)));
        List<String> rd = new ArrayList<>();
        for (int p = i; p <= j; p++) {
            String s1 = s.substring(i, p+1), s2 = s.substring(p+1, j+1);
            if (check(s1) && check2(s2)) {
                if(s1.equals("0") && s2.equals("0")) continue;
                rd.add(s1 + (!s1.isBlank() && !s2.isBlank() ? "." : "") + s2);
            }
        }
        return rd;
    }

    private boolean check(String s) {
        return s.equals("0") || !s.startsWith("0");
    }

    private boolean check2(String s) {
         return !s.endsWith("0");
    }
}