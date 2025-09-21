package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description 字母大小写全排列
 * @email chenbxxx@gmail.con
 * @date 2019/2/28 14:18
 */
public class LeetCode784 {
    class Solution {
        private List<String> res = new ArrayList<>();

        public List<String> letterCasePermutation(String S) {
            dfs(new char[S.length()], S.toCharArray(), 0);
            return res;
        }

        private void dfs(char[] currString, char[] S, int pos) {
            if (pos == S.length) {
                res.add(new String(currString));
                return;
            }
            currString[pos] = S[pos];
            dfs(currString, S, pos + 1);
            if (Character.isLetter(S[pos])) {
                currString[pos] = Character.isUpperCase(S[pos]) ? Character.toLowerCase(S[pos]) : Character.toUpperCase(S[pos]);
                dfs(currString, S, pos + 1);
            }
        }
    }
}
