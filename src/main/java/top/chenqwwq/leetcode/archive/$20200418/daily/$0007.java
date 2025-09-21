package top.chenqwwq.leetcode.archive.$20200418.daily;

import java.util.LinkedList;

/**
 * 面试题59 - II. 队列的最大值
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
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * @author chen
 * @date 2020/3/7 下午2:28
 */
public class $0007 {
    class MaxQueue {

        LinkedList<Integer> data;
        int max = -1;

        public MaxQueue() {
            data = new LinkedList<>();
        }

        public int max_value() {
            return max;
        }

        public void push_back(int value) {
            data.addLast(value);
            if (value > max) {
                max = value;
            }
        }

        public int pop_front() {
            if (data.isEmpty()) {
                return -1;
            }
            final Integer integer = data.removeFirst();
            if (data.isEmpty()) {
                max = -1;
                return integer;
            }
            if (integer == max) {
                Integer first = data.getFirst();
                for (int i = 1; i < data.size(); i++) {
                    first = Math.max(first, data.get(i));

                }
                max = first;
            }

            return integer;
        }
    }
}
