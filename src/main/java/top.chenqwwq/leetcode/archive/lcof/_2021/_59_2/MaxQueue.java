package top.chenqwwq.leetcode.archive.lcof._2021._59_2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * @author chen
 * @date 2021-08-12
 **/
public class MaxQueue {

	PriorityQueue<Integer> priorityQueue;
	Deque<Integer> queue;

	public MaxQueue() {
		priorityQueue = new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o2,o1));
		queue = new LinkedList<Integer>();
	}

	public int max_value() {
		if (priorityQueue.isEmpty()) {
			return -1;
		}
		return priorityQueue.peek();
	}

	public void push_back(int value) {
		queue.addLast(value);
		priorityQueue.add(value);
	}

	public int pop_front() {
		if (queue.isEmpty()) {
			return -1;
		}
		final Integer ans = queue.pop();
		priorityQueue.remove(ans);
		return ans;
	}
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */