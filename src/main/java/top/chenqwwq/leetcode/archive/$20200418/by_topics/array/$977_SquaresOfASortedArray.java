package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * Easy
 * <p>
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 *
 * @author bingxin.chen
 * @date 2019/10/11 12:38
 */
public class $977_SquaresOfASortedArray {

    class Solution {

        // Java8 Lambda
        public int[] sortedSquares(int[] A) {
            return Arrays.stream(A).map(a -> a = (int) Math.pow(a, 2)).sorted().toArray();
        }
    }
}
