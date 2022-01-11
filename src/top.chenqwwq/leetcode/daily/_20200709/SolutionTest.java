package top.chenqwwq.leetcode.daily._20200709;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020-07-09
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void respace() {
        Assertions.assertEquals(7,
                solution.respace(new String[]{"looked", "just", "like", "her", "brother"},
                        "jesslookedjustliketimherbrother"));
    }
}