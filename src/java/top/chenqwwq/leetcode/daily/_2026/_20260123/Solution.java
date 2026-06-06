package top.chenqwwq.leetcode.daily._2026._20260123;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2026/1/23
 **/
public class Solution {
    public int minimumPairRemoval(int[] nums) {
        final int n = nums.length;
        final TreeMap<Long, Long> map = new TreeMap<>();
        final PriorityQueue<long[]> idx2Sum = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] == o2[1]) return Long.compare(o1[0], o2[0]);
                return Long.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < n; i++) {
            map.put((long) i, (long) nums[i]);
            if (i < n - 1) {
                idx2Sum.offer(new long[]{i, nums[i] + nums[i + 1]});
            }
        }

        int cnt = 0;
        while (true) {
            Long cur = -1L, val = Long.MIN_VALUE;
            boolean ok = true;
            while (cur < n) {
                // 找到第一个比 cur 大的元素
                final Map.Entry<Long, Long> next = map.higherEntry(cur);
                if (next == null) break;
                if (next.getValue() >= val) {       // 要非递减
                    cur = next.getKey();
                    val = next.getValue();
                } else {
                    ok = false;
                    break;
                }
            }
            if (ok) break;
            // 开始替换最小的相邻元素和
            while (!idx2Sum.isEmpty()) {
                final long[] poll = idx2Sum.poll();
                if (!map.containsKey(poll[0])) {         // p[0]已经被删除了
                    continue;
                }

                // 获取还存在的最小元素和
                long idx = poll[0];
                // 找到比 idx 的下一个元素
                final Map.Entry<Long, Long> next = map.higherEntry(idx);
                if (next == null) continue;
                if (next.getValue() + map.get(idx) != poll[1]) {
                    // 说明这个元素和已经失效了
                    continue;
                }

                //  和还没有失效
                map.put(idx, poll[1]);          // 修改下标的元素为当前元素和
                map.remove(next.getKey());      // 删除下级元素,删除之后优先级队列里面，以 next.getKey()开头的元素就失效了

                final Map.Entry<Long, Long> n2 = map.higherEntry(idx);
                if (Objects.nonNull(n2)) {
                    idx2Sum.offer(new long[]{idx, map.get(idx) + n2.getValue()});
                }
                // 找到 idx 的上一个元素
                final Long pre = map.lowerKey(idx);
                if (Objects.nonNull(pre)) {
                    idx2Sum.offer(new long[]{pre, map.get(pre) + map.get(idx)});
                }
                cnt++;
                break;
            }

        }
        return cnt;
    }

    public static void main(String[] args) {
        new Solution().minimumPairRemoval(new int[]{-2, 1, 2, -1, -1, -2, -2, -1, -1, 1, 1});
    }
}