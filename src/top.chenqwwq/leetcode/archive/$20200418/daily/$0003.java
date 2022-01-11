package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 * @author chen
 * @date 2020/3/6 下午3:50
 */
public class $0003 {
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int[] migrate = new int[m + n];
            int i = 0, j = 0, curr = 0;

            while (i < m && j < n) {
                if (A[i] > B[j]) {
                    migrate[curr++] = B[j++];
                } else if (A[i] < B[j]) {
                    migrate[curr++] = A[i++];
                } else {
                    migrate[curr++] = A[i++];
                    migrate[curr++] = B[j++];
                }
            }

            while (i < m) {
                migrate[curr++] = A[i++];
            }

            while (j < n) {
                migrate[curr++] = B[j++];
            }

            // 因为Java是传递的复制到的引用对象，所以直接把migrate赋值给A不行

            System.arraycopy(migrate, 0, A, 0, migrate.length);
        }
    }
}
