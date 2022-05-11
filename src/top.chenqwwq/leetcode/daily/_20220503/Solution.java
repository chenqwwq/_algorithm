package top.chenqwwq.leetcode.daily._20220503;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/5/3
 **/
public class Solution {
    public String[] reorderLogFiles(String[] logs) {
//        final int n = logs.length;
//        String[] letter = new String[n], number = new String[n];
//        int l = 0, nu = 0;
//        for (String log : logs) {
//            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
//                number[nu++] = log;
//            } else {
//                letter[l++] = log;
//            }
//        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            map.put(logs[i], i);
        }
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" "), s2 = o2.split(" ");
                if (Character.isDigit(s1[1].charAt(0)) && Character.isDigit(s2[1].charAt(0))) {
                    return Integer.compare(map.get(o1), map.get(o2));
                } else if (Character.isDigit(s1[1].charAt(0))) {
                    return 1;
                } else if (Character.isDigit(s2[1].charAt(0))) {
                    return -1;
                } else {
                    String sb1 = o1.substring(s1[0].length() + 1), sb2 = o2.substring(s2[0].length() + 1);
                    if (sb1.equals(sb2)) {
                        return s1[0].compareTo(s2[0]);
                    }
                    return sb1.compareTo(sb2);
                }
            }
        });
        return logs;
    }
}