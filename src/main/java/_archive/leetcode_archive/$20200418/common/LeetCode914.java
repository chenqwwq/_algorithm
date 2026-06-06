package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 914. 卡牌分组
 * <p>
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 * <p>
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author bingxin.chen
 * @date 2019/8/2 12:42
 */
public class LeetCode914 {
    public static void main(String[] args) {
        System.out.println(new LeetCode914().new Solution().hasGroupsSizeX(new int[]{1, 1}));
    }

    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            if (deck.length < 2) {
                return false;
            }
            // 按照值映射
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : deck) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            // 排序
            final List<Integer> collect = map.values().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            // 求公约数
//            for (int i = 1,sign = collect.get(0);i < collect.size();i++){
//                if(collect.get(i) % sign != 0){
//                    return false;
//                }
//            }

            return true;
        }
    }
}
