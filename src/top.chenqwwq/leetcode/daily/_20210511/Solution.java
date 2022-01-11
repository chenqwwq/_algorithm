package top.chenqwwq.leetcode.daily._20210511;

/**
 * 1734. Decode XORed Permutation
 * There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.
 * <p>
 * It was encoded into another integer array encoded of length n - 1, such that encoded[i] = perm[i] XOR perm[i + 1]. For example, if perm = [1,3,2], then encoded = [2,1].
 * <p>
 * Given the encoded array, return the original array perm. It is guaranteed that the answer exists and is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: encoded = [3,1]
 * Output: [1,2,3]
 * Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * Example 2:
 * <p>
 * Input: encoded = [6,5,4,6]
 * Output: [2,4,1,5,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= n < 105
 * n is odd.
 * encoded.length == n - 1
 *
 * @author chen
 * @date 2021/5/11
 **/
public class Solution {
	public int[] decode(int[] encoded) {

		// 1-n XOR
		int n = 0;
		for (int i = 1; i <= encoded.length + 1; i++) {
			n ^= i;
		}
		int m = 0;
		for (int i = 1; i < encoded.length; i += 2) {
			m ^= encoded[i];
		}

		int first = m ^ n;
		int[] ans = new int[encoded.length + 1];
		ans[0] = first;
		for (int i = 1; i <= encoded.length; i++) {
			ans[i] = ans[i - 1] ^ encoded[i - 1];
		}
		return ans;
	}
}
