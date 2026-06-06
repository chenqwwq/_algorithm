package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author CheNbXxx
 * @description 以其中一个字符串的中的char为key, 另一个为value产生映射关系。
 * 修改： 单一以其中一个作为key不行，需要互为k/v
 * @email chenbxxx@gmail.con
 * @date 2019/1/21 17:41
 */
@Slf4j
public class LeetCode205 {
    public static void main(String[] args) {
        log.info(new Solution().isIsomorphic("ab", "aa") + "");
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            int len;
            if (s == null || t == null || (len = s.length()) != t.length()) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>(len);
            // s为key
            char[] sChars = s.toCharArray();
            // t为value
            char[] tChars = t.toCharArray();
            for (int i = 0; i < len; i++) {
                // 1. 判断s中的char是否存在
                if (map.containsKey(sChars[i])) {
                    // 2. 存在继续判断value是否相等
                    if (!map.get(sChars[i]).equals(tChars[i])) {
                        return false;
                    }
                    continue;
                }
                map.put(sChars[i], tChars[i]);
            }
            // 判断value是否有重复
            return new HashSet<>(map.values()).size() == map.values().size();
        }
    }
}
