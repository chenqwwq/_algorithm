package top.chenqwwq.leetcode.contest.weekly._356._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2023/7/30
 **/
public class Solution {

    public String minimumString(String a, String b, String c) {
        List<String> anss = new ArrayList<>();
        anss.add(handle(a, b, c));
        anss.add(handle(a, c, b));
        anss.add(handle(b, a, c));
        anss.add(handle(b, c, a));
        anss.add(handle(c, b, a));
        anss.add(handle(c, a, b));

        anss.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

        return anss.get(0);
    }


    public String handle(String a, String b, String c) {
        return handle(handle(a, b), c);
    }

    public String handle(String a, String b) {
        if(a.contains(b)) return a;
        if(b.contains(a)) return b;
        final int n = a.length(), m = b.length();

        int i = Math.min(n, m);
        for (; i > 0; i--) {
            if (a.substring(n - i).equals(b.substring(0, i))) {
                break;
            }
        }

        if (i < b.length()) return a + b.substring(i);
        else return a;

    }
}