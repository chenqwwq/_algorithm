package top.chenqwwq.leetcode.lcof._2020._31;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2}
 * 就不可能是该压栈序列的弹出序列。
 * <p>
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/15 下午9:37
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 栈大小
        int size = 0;
        for (int i = 0, j = 0; i < pushed.length; i++) {
            // 入栈一个数
            pushed[size++] = pushed[i];

            while (size != 0 && pushed[size - 1] == popped[j]) {
                size--;
                j++;
            }
        }
        return size == 0;
    }
}
