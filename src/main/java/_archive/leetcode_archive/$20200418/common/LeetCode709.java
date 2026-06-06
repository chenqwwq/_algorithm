package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author CheNbXxx
 * @description 大写转小写
 * @email chenbxxx@gmail.con
 * @date 2019/3/1 10:25
 */
public class LeetCode709 {
    public static void main(String[] args) {
        System.out.println((int) '(');
    }

    class Solution {
        public String toLowerCase(String str) {
            final char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    chars[i] = (char) (chars[i] + 32);
                }
            }
            return new String(chars);
        }
    }
}
