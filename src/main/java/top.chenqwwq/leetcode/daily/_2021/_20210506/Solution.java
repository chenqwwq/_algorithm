package top.chenqwwq.leetcode.daily._2021._20210506;

/**
 * 1720. Decode XORed Array
 * There is a hidden integer array arr that consists of n non-negative integers.
 * <p>
 * It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].
 * <p>
 * You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
 * <p>
 * Return the original array arr. It can be proved that the answer exists and is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: encoded = [1,2,3], first = 1
 * Output: [1,0,2,1]
 * Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * Example 2:
 * <p>
 * Input: encoded = [6,2,7,3], first = 4
 * Output: [4,2,0,7,4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 *
 * @author chen
 * @date 2021-05-06
 **/
public class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length+1];
        ans[0] = first;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }
        return ans;
    }
}
