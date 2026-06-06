package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 179. 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * @author chen
 * @date 2020/3/23 下午1:14
 */
public class $179_LargestNumber {

    public static void main(String[] args) {
        System.out.println(new $179_LargestNumber().new Solution().largestNumber(new int[]{10, 2}));
    }

    class Solution {

        public String largestNumber(int[] nums) {
            final String collect = Arrays.stream(nums)
                    .boxed()
                    .map(String::valueOf)
                    .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                    .collect(Collectors.joining());
            return collect.charAt(0) == '0' ? "0" : collect;
        }
    }
}
