package top.chenqwwq.leetcode.weekly._232._1;

/**
 * 5701. 仅执行一次字符串交换能否使两个字符串相等 显示英文描述
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * 示例 4：
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 *
 * @author chen
 * @date 2021/3/14
 **/
public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int cL = s1.length();
        Character c1 = null, c2 = null;

        for (int i = 0; i < cL; i++) {
            char c = s1.charAt(i);
            char d = s2.charAt(i);
            if (c != d) {
                if (c1 == null) {
                    c1 = c;
                    c2 = d;
                } else {
                    if (c != c2 || d != c1) {
                        return false;
                    }
                    c1 = 'Q';
                }
            }
        }
        return c1 == null || c1 == 'Q';
    }
}
