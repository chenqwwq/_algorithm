package top.chenqwwq.leetcode.daily._20220106;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2022/1/6
 **/
class SolutionTest {

    @Test
    void simplifyPath() {
        Solution solution = new Solution();
        Assertions.assertEquals("/",solution.simplifyPath("/a/.."));
        Assertions.assertEquals("/c",solution.simplifyPath("/a/./b/../../c/"));
    }

}