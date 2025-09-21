package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chen
 * @description
 * @email ai654778@vip.qq.com
 * @date 19-1-27
 */
@Slf4j
public class LeetCode423 {
    public static void main(String[] args) {
        log.info("c-a:{}", ('z' - 'a'));
    }

    static class Solution {
        public String originalDigits(String s) {
            final char[] chars = s.toCharArray();
            int[] numArray = new int[10];
            int[] charArray = new int[26];
            for (char c : chars) {
                charArray[c - 'a']++;
            }
            // 此处'z' - 'a'直接转化为数字还能再快一点
            // z -> zero,w -> two,u -> four,x -> six,g -> eight
            // 0,2,4,6,8 字母专有所以个数确定
            numArray[0] = charArray['z' - 'a'];
            numArray[2] = charArray['w' - 'a'];
            numArray[4] = charArray['u' - 'a'];
            numArray[6] = charArray['x' - 'a'];
            numArray[8] = charArray['g' - 'a'];


            numArray[1] = charArray['o' - 'a'] - numArray[0] - numArray[2] - numArray[4];
            numArray[3] = charArray['h' - 'a'] - numArray[8];
            numArray[5] = charArray['f' - 'a'] - numArray[4];

            numArray[7] = charArray['v' - 'a'] - numArray[5];
            numArray[9] = charArray['i' - 'a'] - numArray[6] - numArray[8] - numArray[5];

            StringBuilder res = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < numArray[i]; j++) {
                    res.append(i);
                }
            }

            return res.toString();
        }
    }
}
