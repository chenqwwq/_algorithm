package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 895. Maximum Frequency Stack
 * <p>
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 * <p>
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 * <p>
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 * The stack becomes [5,7,5,4].
 * <p>
 * pop() -> returns 5.
 * The stack becomes [5,7,4].
 * <p>
 * pop() -> returns 4.
 * The stack becomes [5,7].
 * <p>
 * <p>
 * Note:
 * <p>
 * Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
 * It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
 * The total number of FreqStack.push calls will not exceed 10000 in a single test case.
 * The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
 * The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.
 *
 * @author chen
 * @date 19-7-10 下午11:23
 */
public class LeetCode895 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

    /**
     * 实现按照频率排序的栈
     */
    static class FreqStack {

        /**
         * 以动态数组和栈组合的方式存储具体的值
         * 1. List的下标表示出现的频率
         * 2. Stack存储数值
         */
        List<Stack<Integer>> values;

        /**
         * HashMap不能直接排序,TreeMap只能按照Key排序
         * <p>
         * 根据频率排序的Map
         * <p>
         * key为值,value为出现频率
         * 适合写入多,读取少的场景
         */
        HashMap<Integer, Integer> freqMap;

        public FreqStack() {
            values = new ArrayList<>();
            freqMap = new HashMap<>();
        }

        /**
         * 获取Map中的频率,+1
         * 对应频率塞数据
         */
        public void push(int x) {
            // 更新x的频率
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);

            // 表示还没有出现过这种频率的元素
            // 新加一个桶
            if (freqMap.get(x) > values.size()) {
                values.add(new Stack<>());
            }
            // 塞数据
            values.get(freqMap.get(x) - 1).push(x);
        }

        /**
         * 直接从最后的Stack中pop数据
         * 降低频率
         * 清理空栈,空map
         */
        public int pop() {
            if (values.size() == 0 || freqMap.size() == 0) {
                return -1;
            }
            // 直接从最后的Stack中弹出
            // 维护数组中都必须是非空的栈
            Integer pop = values.get(values.size() - 1).pop();

            // 清理空栈
            if (values.get(values.size() - 1).isEmpty()) {
                values.remove(values.size() - 1);
            }

            // 降低Map中pop的频率
            freqMap.put(pop, freqMap.get(pop) - 1);
            if (freqMap.get(pop) == 0) {
                freqMap.remove(pop);
            }
            return pop;
        }
    }

/**
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
}
