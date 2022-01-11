package top.chenqwwq.leetcode.daily._20200811;

import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020-08-11
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void solve() {
        final char[][] chars = {{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};

        solution.solve(chars);
    }
}