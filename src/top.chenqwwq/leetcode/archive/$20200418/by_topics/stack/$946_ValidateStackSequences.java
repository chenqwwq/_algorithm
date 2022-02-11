package top.chenqwwq.leetcode.archive.$20200418.by_topics.stack;

/**
 * 946. 验证栈序列
 * <p>
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 *
 * @author bingxin.chen
 * @date 2019/12/16 14:06
 */
public class $946_ValidateStackSequences {

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            // 使用数组代替栈
            // 不开辟新数组
            int currSize = 0;
            for (int pushIndex = 0, popIndex = 0; pushIndex < pushed.length; pushIndex++) {
                pushed[currSize++] = pushed[pushIndex];
                while (currSize != 0 && pushed[currSize - 1] == popped[popIndex]) {
                    currSize--;
                    popIndex++;
                }
            }

            return currSize == 0;
        }
    }

//    class Solution {
//        public boolean validateStackSequences(int[] pushed, int[] popped) {
//            // 使用数组代替栈
//            int currSize = 0;
//            int[] stack = new int[pushed.length];
//            for (int pushIndex = 0,popIndex = 0;pushIndex < pushed.length;pushIndex++){
//                stack[currSize++] = pushed[pushIndex];
//                while (currSize != 0 && stack[currSize - 1] == popped[popIndex]){
//                    currSize--;
//                    popIndex++;
//                }
//            }
//
//            return currSize == 0;
//        }
//    }

//    class Solution {
//        public boolean validateStackSequences(int[] pushed, int[] popped) {
//            final int pushLength = pushed.length;
//            final int popLength = popped.length;
//            if(pushLength != popLength){
//                return false;
//            }
//            Stack<Integer> stack = new Stack<>();
//
//            int pushIndex = 0,popIndex = 0;
//            while (pushIndex < pushed.length && popIndex < popped.length) {
//                if (stack.isEmpty() || !stack.peek().equals(popped[popIndex])) {
//                    stack.push(pushed[pushIndex++]);
//                    continue;
//                }
//                // 不为空,切栈顶元素正确
//                popIndex++;
//                stack.pop();
//            }
//
//            while (!stack.isEmpty()){
//                if(stack.pop() != popped[popIndex++]){
//                    return false;
//                }
//            }
//
//            return pushIndex == popIndex;
//        }
//    }

}
