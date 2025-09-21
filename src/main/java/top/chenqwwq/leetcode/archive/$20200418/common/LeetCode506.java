package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/21 10:32
 */
@Slf4j
public class LeetCode506 {
    static class Solution {
        private List<Integer> sorted;

        public String[] findRelativeRanks(int[] nums) {
            sorted = IntStream.of(nums)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
            return Arrays.stream(nums)
                    .mapToObj((IntFunction<Object>) this::conversion)
                    .toArray(String[]::new);
        }

        private String conversion(int i) {
            int index = sorted.indexOf(i);
            switch (index) {
                case 0:
                    return "Gold Medal";
                case 1:
                    return "Silver Medal";
                case 2:
                    return "Bronze Medal";
                default:
                    return String.valueOf(index + 1);
            }
        }
    }
}
