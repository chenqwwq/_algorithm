package top.chenqwwq.leetcode.contest.weekly._231._1;

/**
 * 5697. 检查二进制字符串字段 显示英文描述
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * 示例 1：
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 * 示例 2：
 * 输入：s = "110"
 * 输出：true
 * 提示：
 * 1 <= s.length <= 100
 * s[i]​​​​ 为 '0' 或 '1'
 * s[0] 为 '1'
 *
 * @author chen
 * @date 2021/3/7
 **/
public class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag = true;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                flag = false;
            } else if (c == '1' && !flag) {
                return false;
            }
        }

        return true;
    }
}
