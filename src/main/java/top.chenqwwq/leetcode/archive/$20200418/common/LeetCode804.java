package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.HashSet;
import java.util.Set;

/**
 * @author CheNbXxx
 * @description 摩斯密码转换
 * @email chenbxxx@gmail.con
 * @date 2019/3/1 10:33
 */
public class LeetCode804 {
    class Solution {
        private final String[] PASSWORD = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "src/chenqwwq/leetcode/src/main", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        private Set<String> set = new HashSet<>();

        public int uniqueMorseRepresentations(String[] words) {
            StringBuilder temp = new StringBuilder();
            // 因为只包含小写字母 97~122
            for (String s : words) {
                for (char c : s.toCharArray()) {
                    temp.append(PASSWORD[c - 97]);
                }
                set.add(temp.toString());
                temp.delete(0, temp.length());
            }
            return set.size();
        }
    }
}
