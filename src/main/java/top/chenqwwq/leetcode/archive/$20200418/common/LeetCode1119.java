package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @date 19-7-13 下午10:39
 */
public class LeetCode1119 {
    class Solution {
        public String removeVowels(String S) {
            return S.replaceAll("a", "")
                    .replaceAll("e", "")
                    .replaceAll("i", "")
                    .replaceAll("o", "")
                    .replaceAll("u", "");
        }
    }
}
