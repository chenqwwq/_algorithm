package top.chenqwwq.leetcode.biweek._30._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1：
 * <p>
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 * 示例 2：
 * <p>
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 * 示例 3：
 * <p>
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 *
 * @author chen
 * @date 2020/7/11 下午10:36
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void reformatDate() {
        Assertions.assertEquals("2052-10-20", solution.reformatDate("20th Oct 2052"));
        Assertions.assertEquals("1933-06-06", solution.reformatDate("6th Jun 1933"));
        Assertions.assertEquals("2023-04-22", solution.reformatDate("22nd Apr 2023"));
        Assertions.assertEquals("1960-05-26", solution.reformatDate("26th May 1960"));

    }
}