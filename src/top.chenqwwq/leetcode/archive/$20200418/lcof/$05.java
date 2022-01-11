package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 *
 * @author chen
 * @date 2020/3/6 下午3:12
 */
public class $05 {
    class Solution {
        public String replaceSpace(String s) {
            return s.replace(" ", "%20");
        }
    }
}
