package top.chenqwwq.leetcode.weekly._185._3;

import java.util.HashMap;
import java.util.Map;

/**
 * 5390. 数青蛙 显示英文描述
 * 题目难度Medium
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 * <p>
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 *
 * @author chen
 * @date 2020/4/19 上午11:03
 */
public class Solution {
    private final char[] CROAK = new char[]{'c', 'r', 'o', 'a', 'k'};

    private Map<Character, Integer> HASH = new HashMap<Character, Integer>() {{
        put('c', 0);
        put('r', 1);
        put('o', 2);
        put('a', 3);
        put('k', 4);
    }};


    public int minNumberOfFrogs(String croakOfFrogs) {
        // abnormal situation
        if (croakOfFrogs == null
                || croakOfFrogs.length() == 0
                || croakOfFrogs.length() % CROAK.length != 0
                || !croakOfFrogs.startsWith("c")) {
            return -1;
        }

        // init
        Map<Integer, Integer> map = new HashMap<>(5);
        final char[] chars = croakOfFrogs.toCharArray();
        map.put(1, 1);
        int curr = 1, max = 1;

        for (int i = 1; i < croakOfFrogs.length(); i++) {
            // 确定当前字符下标
            final Integer integer = HASH.get(chars[i]);
            // 确定当前是否有需要改下标的
            if (integer == 0) {
                map.put(1, map.get(1) + 1);
                max = Math.max(++curr, max);
                continue;
            }
            if (map.getOrDefault(integer, 0) == 0) {
                return -1;
            }

            map.put(integer, map.get(integer) - 1);
            if (integer == 4) {
                curr--;
            } else {
                map.put(integer + 1, map.getOrDefault(integer + 1, 0) + 1);
            }

        }

        for (int i : map.values()) {
            if (i != 0) {
                return -1;
            }
        }

        return max;
    }
}