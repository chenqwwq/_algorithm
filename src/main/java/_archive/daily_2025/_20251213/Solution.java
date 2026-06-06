package top.chenqwwq.leetcode.daily._2025._20251213;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2025/12/13
 **/
public class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        final int n = code.length;
        List<String[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isActive[i]) continue;
            if (!c1(code[i])) continue;
            if (get(businessLine[i]) < 0) continue;
            ans.add(new String[]{code[i], businessLine[i]});
        }

        ans.sort(((Comparator<String[]>) (o1, o2) -> Integer.compare(get(o1[1]), get(o2[1]))).thenComparing(o1 -> o1[0]));
        List<String> ret = new ArrayList<>();
        for (String[] s : ans) {
            ret.add(s[0]);
        }
        return ret;
    }

    private int get(String s) {
        if (Objects.equals(s, "electronics")) return 1;
        if (Objects.equals(s, "grocery")) return 2;
        if (Objects.equals(s, "pharmacy")) return 3;
        if (Objects.equals(s, "restaurant")) return 4;
        return -1;
    }

    private boolean c1(String s) {
        if (s == null || s.isBlank()) return false;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') continue;
            if (c >= 'A' && c <= 'Z') continue;
            if (c >= '0' && c <= '9') continue;
            if (c == '_') continue;
            return false;
        }
        return true;
    }

}