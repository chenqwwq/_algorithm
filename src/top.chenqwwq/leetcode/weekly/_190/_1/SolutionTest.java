package top.chenqwwq.leetcode.weekly._190._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/24 上午10:34
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isPrefixOfWord() {
        Assertions.assertEquals(4, solution.isPrefixOfWord("i love eating burger", "burg"));
        Assertions.assertEquals(2, solution.isPrefixOfWord("this problem is an easy problem", "pro"));
        Assertions.assertEquals(-1, solution.isPrefixOfWord("i am tired", "you"));
        Assertions.assertEquals(4, solution.isPrefixOfWord("i use triple pillow", "pill"));
        Assertions.assertEquals(-1, solution.isPrefixOfWord("hello from the other side", "they"));
    }
}