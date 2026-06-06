package top.chenqwwq.leetcode.topic.greedy._1005;

/**
 * 1005. K 次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * <p>
 * 以这种方式修改数组后，返回数组可能的最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 * <p>
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 * <p>
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 *
 * @author chen
 * @date 2020/10/24
 **/
public class Solution {
    // 太暴力的
//    public int largestSumAfterKNegations(int[] A, int K) {
//        // 每次都选择最小的，重新放回去然后排序
//        while (K > 0) {
//            Arrays.sort(A);
//            A[0] = -A[0];
//            K--;
//        }
//
//        int sum = 0;
//        for (int i : A) {
//            sum += i;
//        }
//
//        return sum;
//    }

    public int largestSumAfterKNegations(int[] A, int K) {
        // 因为A[i]的取值范围不大，所以可以直接映射
        int[] hash = new int[201];
        for (int i : A) {
            hash[i + 100]++;
        }

        // 从0开始选择
        int i = 0;
        while (K > 0) {
            // 找到第一个不为0的数字，就是最小数组
            while (i <= 200 && hash[i] == 0) {
                i++;
            }
            // 正负互换
            // i = c + 100
            // -c = 100 - i
            hash[i]--;
            hash[200 - i]++;
            if (i > 100) {
                i = 200 - i;
            }
            K--;
        }

        // 求和
        int sum = 0;
        for (int j = 0; j <= 200; j++) {
            sum += ((j - 100) * hash[j]);
        }
        return sum;
    }
}