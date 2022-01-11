package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/18 14:09
 */
@Slf4j
public class LeetCode791 {
    public static void main(String[] args) {
        log.info(new Solution().customSortString("kqep", "pekeq"));
    }

    static class Solution {
        public String customSortString(String S, String T) {
            int[] a = new int[26];
            // int数组a记录全部的字母的个数
            for (int i = 0; i < T.length(); i++) {
                a[T.charAt(i) - 'a']++;
            }
            StringBuilder result = new StringBuilder();
            // for循环遍历作为比对的字符串，一个一个加上去
            for (int i = 0; i < S.length(); i++) {
                int i1 = S.charAt(i) - 'a';
                for (int j = 0; j < a[i1]; j++) {
                    result.append(S.charAt(i));
                }
                a[i1] = 0;
            }

            // 把不为空的都加上
            for (int i = 0; i < a.length; i++) {
                if (a[i] != 0) {
                    for (int j = 0; j < a[i]; j++) {
                        result.append((char) ('a' + i));
                    }
                }
            }

            return result.toString();
        }
    }
}
