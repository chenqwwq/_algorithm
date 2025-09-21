package top.chenqwwq.leetcode.topic.backtrack._877;

/**
 * 877. Stone Game
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 * <p>
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 * <p>
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 * <p>
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [5,3,4,5]
 * Output: true
 * Explanation:
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= piles.length <= 500
 * piles.length is even.
 * 1 <= piles[i] <= 500
 * sum(piles) is odd.
 *
 * @author chen
 * @date 2021/5/21
 **/
public class Solution {

	// errorover:  回溯超时，暂时没有好的减枝办法
	public boolean stoneGame(int[] piles) {
		return dfs(piles, 1, 0, piles.length - 1) > 0;
	}

	public int dfs(int[] piles, int turn, int left, int right) {
		if (left == right) {
			return turn * piles[left];
		}

		final int ml = piles[left] * turn + dfs(piles, -turn, left + 1, right);
		final int mr = piles[right] * turn + dfs(piles, -turn, left, right - 1);

		return Math.max(ml * turn, mr * turn) * turn;
	}
}