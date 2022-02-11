package top.chenqwwq.leetcode.weekly._190._2;

import java.util.HashSet;
import java.util.Set;

/**
 * 5417. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 *
 * @author chen
 * @date 2020/5/24 上午10:36
 */
public class Solution {

    private static final Set<Character> hash = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};

    public int maxVowels(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0 || s.length() < k) {
            return 0;
        }

        // 定长滑动数组
        final char[] chars = s.toCharArray();
        int left = 0, right = k - 1;
        int max = 0;

        // 初始遍历
        for (int i = left; i <= right; i++) {
            if (hash.contains(chars[i])) {
                max++;
            }
        }
        int num = max;

        while (++right < s.length()) {
            if (hash.contains(chars[right])) {
                num++;
            }

            if (hash.contains(chars[left++])) {
                num--;
            }
            max = Math.max(num, max);
        }

        return max;
    }
}