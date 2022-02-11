package top.chenqwwq.leetcode.daily._20200718;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/18 下午2:31
 */
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void isInterleave() {
        Assertions.assertTrue(solution.isInterleave("a", "", "a"));
        Assertions.assertTrue(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assertions.assertFalse(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}