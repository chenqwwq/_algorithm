package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内
 *
 * @author chen
 * @date 2020/3/16 上午8:16
 */
public class $0016 {
    class Solution {
        public String compressString(String S) {
            if (S == null || S.length() == 0) {
                return "";
            }
            final char[] chars = S.toCharArray();

            int num = 1;
            char flag = chars[0];
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < chars.length; i++) {
                if (flag == chars[i]) {
                    num++;
                } else {
                    sb.append(flag).append(num);
                    num = 1;
                    flag = chars[i];
                }
            }

            sb.append(flag).append(num);
            return sb.length() < S.length() ? sb.toString() : S;
        }
    }
}
