package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;

/**
 * 58.  最后一个单词的长度
 * <p>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author bingxin.chen
 * @date 2019/7/18 12:05
 */
public class LeetCode58 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("1 2 2".split(" ")));
    }

    class Solution {
        public int lengthOfLastWord(String s) {
            final String[] s1 = s.split(" ");
            if (s1.length < 1) {
                return 0;
            }
            return s1[s1.length - 1].length();
        }
    }
}
