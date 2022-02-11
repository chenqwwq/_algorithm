package top.chenqwwq.leetcode.biweek._26._4_in_error;

import java.util.*;

/**
 * 5399. 数位成本和为目标值的最大数字 显示英文描述
 * <p>
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * <p>
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 * <p>
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * 提示：
 * <p>
 * cost.length == 9
 * 1 <= cost[i] <= 5000
 * 1 <= target <= 5000
 *
 * @author chen
 * @date 2020/5/16 下午11:30
 */
public class Solution {

    public String largestNumber(int[] cost, int target) {
        // 先从cost数组中选出符合target的组合
        // 然后排列组合

        // 选取cost的时候位数越高数值越大，所以从最小的选起

        // 先将价值和数位作hash，数位只保留最大的
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            // 直接覆盖,i会越来越大的
            hash.put(cost[i], i + 1);
        }

        // 取所有的key,并排序
        final List<Integer> keyList = new ArrayList<>(hash.keySet());
        Collections.sort(keyList);

        // 递归取最终集合
        List<Integer> list = new ArrayList<>();
        getTarget(keyList, target, list);


        // hash翻译
        List<Integer> noHash = new ArrayList<>();
        for (int i : list) {
            noHash.add(hash.get(i));
        }
        noHash.sort(Comparator.reverseOrder());

        StringBuilder res = new StringBuilder();
        for (int i : noHash) {
            res.append(i);
        }

        return res.length() == 0 ? "0" : res.toString();
    }


    /**
     * 回溯求和
     * 保证已经去过重，且排序
     */
    public boolean getTarget(List<Integer> list, int target, List<Integer> res) {
        if (target == 0) {
            return true;
        }
        for (int i : list) {
            if (target >= i) {
                res.add(i);
                if (getTarget(list, target - i, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

}
