package top.chenqwwq.leetcode.daily._20211225;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.common.TreeNode;
import top.chenqwwq.leetcode.daily._20211225.Solution;

import javax.xml.soap.SOAPMessage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/25
 **/
class SolutionTest {

    @Test
    void isEvenOddTree() {
        final Solution solution = new Solution();
        final boolean evenOddTree = solution.isEvenOddTree(new TreeNode(1, new TreeNode(10, new TreeNode(3, new TreeNode(12), new TreeNode(8)), null), new TreeNode(4, new TreeNode(7, new TreeNode(6), null), new TreeNode(9, null, new TreeNode(2)))));
        Assertions.assertTrue(evenOddTree);
    }
}