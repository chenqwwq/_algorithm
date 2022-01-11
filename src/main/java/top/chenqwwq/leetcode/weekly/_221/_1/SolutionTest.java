package top.chenqwwq.leetcode.weekly._221._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/12/27
 **/
class SolutionTest {
    /**
     * s = "book"
     * 输出：true
     * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
     * 示例 2：
     * <p>
     * 输入：s = "textbook"
     * 输出：false
     * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
     * 注意，元音 o 在 b 中出现两次，记为 2 个。
     * 示例 3：
     * <p>
     * 输入：s = "MerryChristmas"
     * 输出：false
     * 示例 4：
     * <p>
     * 输入：s = "AbCdEfGh"
     * 输出：true
     */

    Solution solution = new Solution();

    @Test
    void halvesAreAlike() {
        Assertions.assertTrue(solution.halvesAreAlike("book"));
        Assertions.assertFalse(solution.halvesAreAlike("textbook"));
        Assertions.assertFalse(solution.halvesAreAlike("MerryChristmas"));
        Assertions.assertTrue(solution.halvesAreAlike("AbCdEfGh"));
    }
}