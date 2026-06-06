package top.chenqwwq.leetcode.topic.array._1035;

/**
 * 1035. Uncrossed Lines
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * <p>
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 * <p>
 * A[i] == B[j];
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * <p>
 * Return the maximum number of connecting lines we can draw in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 * Example 2:
 * <p>
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 * Example 3:
 * <p>
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 500
 * 1 <= B.length <= 500
 * 1 <= A[i], B[i] <= 2000
 *
 * @author chen
 * @date 2021-05-11
 **/
public class Solution {
	public int maxUncrossedLines(int[] A, int[] B) {
		final int a = A.length;
		final int b = B.length;
		int[][] dp = new int[a + 1][b + 1];

		// init
		int cnt = 0;
		for (int i = 1; i <= a; i++) {
			if (A[i - 1] == B[0]) {
				cnt = 1;
			}
			dp[i][1] = cnt;
		}
		cnt = 0;
		for (int i = 1; i <= b; i++) {
			if (B[i - 1] == A[0]) {
				cnt = 1;
			}
			dp[1][i] = cnt;
		}

		for (int i = 2; i <= a; i++) {
			for (int j = 2; j <= b; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[a][b];
	}
}