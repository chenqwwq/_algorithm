package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 412. Fizz Buzz
 *
 * @author chen
 * @date 19-5-19
 */
public class LeetCode412 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode412().new Solution().fizzBuzz(15).toArray()));
    }

    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) {
                    res.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    res.add("Fizz");
                } else if (i % 5 == 0) {
                    res.add("Buzz");
                } else {
                    res.add(String.valueOf(i));
                }
            }
            return res;
        }
    }
}
