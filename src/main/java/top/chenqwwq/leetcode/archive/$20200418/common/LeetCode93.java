package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/22 14:04
 */
@Slf4j
public class LeetCode93 {
    public static void main(String[] args) {
        log.info(new Solution().restoreIpAddresses("25525511135") + "");
    }

    static class Solution {
        /**
         * 存放已经确认正确的IP地址
         */
        private List<String> result = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            handle(0, s, "", 0);
            return result;
        }

        private void handle(int startIndex, String s, String prevString, int depth) {
            // 类似于深度优先搜索遍历，判断是否到叶子节点
            if (startIndex == s.length() && depth == 4) {
                result.add(prevString.substring(1));
                return;
            }
            if (depth > 3) {
                return;
            }
            // 递归回溯
            for (int j = 1; j <= 3 && startIndex + j < s.length() + 1; j++) {
                String substring = s.substring(startIndex, startIndex + j);
                // 排除掉错误的部分
                if (Integer.valueOf(substring) > 255 || (substring.length() > 1 && '0' == substring.charAt(0))) {
                    continue;
                }
                String s1 = prevString + "." + substring;
                handle(startIndex + j, s, s1, depth + 1);
            }
        }
    }
}
