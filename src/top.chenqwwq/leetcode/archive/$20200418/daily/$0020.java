package top.chenqwwq.leetcode.archive.$20200418.daily;

import java.util.PriorityQueue;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 通过次数30,337提交次数49,689
 *
 * @author chen
 * @date 2020/3/20 下午9:45
 */
public class $0020 {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || arr.length <= k) {
                return arr;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);

            for (int i = 0; i < arr.length; i++) {
                if (queue.size() < k) {
                    queue.offer(arr[i]);
                } else if (queue.peek() != null && queue.peek() > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }

            int[] i = new int[k];
            int ind = 0;
            while (queue.peek() != null) {
                i[ind] = queue.poll();
                ind++;
            }
            return i;
        }
    }
}
