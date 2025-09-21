package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 1025. Divisor Game
 * Easy
 * <p>
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 * <p>
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 * <p>
 * Input: 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000
 *
 * @author bingxin.chen
 * @date 2019/9/5 12:18
 */
public class $1025_DivisorsGame {

    /**
     * dp[n]表示数字为N的时候,Alice是否可以赢
     * 非最简方法,实践dp
     * <p>
     * dp[n] = foreach(N % [1~n] == 0 && !dp[i])
     */
    class Solution {
        public boolean divisorGame(int N) {
            boolean[] dp = new boolean[N + 1];

            for (int i = 2; i <= N; i++) {
                for (int j = 1; j < i; j++) {
                    if (i % j == 0 && !dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[N];
        }
    }
}
