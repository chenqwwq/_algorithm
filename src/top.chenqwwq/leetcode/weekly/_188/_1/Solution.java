package top.chenqwwq.leetcode.weekly._188._1;

import java.util.ArrayList;
import java.util.List;

/**
 * 5404. 用栈操作构建数组 显示英文描述
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。
 * <p>
 * 题目数据保证答案是唯一的。题目数据保证答案是唯一的
 *
 * @author chen
 * @date 2020/5/10 上午10:48
 */
public class Solution {
    private static final String PUSH = "Push";

    private static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        final ArrayList<String> res = new ArrayList<>();
        if (target[target.length - 1] > n) {
            return res;
        }

        for (int i = 1, tIndex = 0; i <= n; i++) {
            res.add(PUSH);
            if (target[tIndex] > i) {
                res.add(POP);
            } else {
                if (++tIndex == target.length) {
                    return res;
                }
            }
        }

        return res;
    }
}