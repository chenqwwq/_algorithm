package top.chenqwwq.leetcode.lcof._2021._41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 最多会对 addNum、findMedian 进行 50000 次调用
 *
 * @author chen
 * @date 2021-05-26
 **/
public class MedianFinder {

	PriorityQueue<Integer> max, min;
	int cnt = 0;

	/**
	 * initialize your data structure here.
	 */
	public MedianFinder() {
		// 前半段大顶堆
		min = new PriorityQueue<>(Comparator.reverseOrder());
		// 后半段小顶堆
		max = new PriorityQueue<>();
	}

	/**
	 * 重点还是在维持两个堆
	 * 1. 保证堆的大小之差不超过1
	 * 2. 保证小堆的元素全部小于大堆
	 * <p>
	 * * 存在输入为-1，-2，-3
	 */
	public void addNum(int num) {
		// 都先加到后半段
		min.offer(num);
		max.offer(min.poll());
		while (min.size() < max.size()) {
			min.offer(max.poll());
		}
		cnt++;
	}

	public double findMedian() {
		if (cnt == 0) {
			return -1;
		}
		if ((cnt & 1) == 1) {
			return min.peek();
		} else {
			return (min.peek() + max.peek()) / 2.0;
		}
	}
}