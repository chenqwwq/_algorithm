package top.chenqwwq.leetcode.daily._2022._20220913;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/9/13
 **/
public class Solution {
    public int maximumSwap(int num) {
        List<Integer> sort = new ArrayList<>();
        LinkedList<Integer> nums = new LinkedList<>();
        int fake = num;
        while (fake != 0) {
            int cur = fake % 10;
            nums.addFirst(cur);
            sort.add(cur);
            fake /= 10;
        }
        final int n = sort.size();
        sort.sort((o1, o2) -> Integer.compare(o2, o1));
        int a = -1, b = -1;
        int ans = 0;
        int i = 0;
        for (; i < n; i++) {
            if (Objects.equals(nums.get(i), sort.get(i))) {
                ans = ans * 10 + nums.get(i);
            } else {
                ans = ans * 10 + sort.get(i);
                a = sort.get(i);
                b = nums.get(i);
                break;
            }
        }
        // 从后往前选择和a相同的数组并替换
        for (int j = n - 1; j > i; j--) {
            if (nums.get(j).equals(a)) {
                nums.set(j, b);
                break;
            }
        }
        while (++i < n){
            ans = ans * 10 + nums.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().maximumSwap(2763);
    }
}