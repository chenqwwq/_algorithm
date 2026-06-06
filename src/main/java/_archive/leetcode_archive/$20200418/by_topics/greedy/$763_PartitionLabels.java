package top.chenqwwq.leetcode.archive.$20200418.by_topics.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 763. 划分字母区间
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 *
 * @author chen
 * @date 2019/11/29 下午11:02
 */
public class $763_PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            if (S.length() <= 1) {
                return Collections.singletonList(1);
            }
            // char -> index
            final char[] chars = S.toCharArray();
            int[] hash = new int[26];

            for (int i = 0; i < chars.length; i++) {
                hash[chars[i] - 'a'] = i;
            }


            List<Integer> res = new ArrayList<>();
            for (int i = 0, start = -1, end = 0; i < chars.length; i++) {
                int t;
                if ((t = hash[chars[i] - 'a']) > end) {
                    end = t;
                }

                if (i >= end) {
                    res.add(end - start);
                    i = start = end;
                }
            }

            return res;
        }
    }
}
