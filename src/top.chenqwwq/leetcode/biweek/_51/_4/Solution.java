package top.chenqwwq.leetcode.biweek._51._4;

import java.util.*;

/**
 * @author chen
 * @date 2021/5/1
 **/
public class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Map<Integer, List<Integer>> hash = new HashMap<>();
        for (int[] room : rooms) {
            final List<Integer> ids = hash.getOrDefault(room[1], new ArrayList<>());
            ids.add(room[0]);
            hash.put(room[1], ids);
        }
        final ArrayList<Map.Entry<Integer, List<Integer>>> entries = new ArrayList<>(hash.entrySet());
        entries.sort(Comparator.comparingInt(Map.Entry::getKey));
        entries.get(entries.size() - 1).getValue().sort(Integer::compareTo);
        for (int i = entries.size() - 2; i >= 0; i--) {
            entries.get(i).getValue().addAll(entries.get(i + 1).getValue());
            entries.get(i).getValue().sort(Integer::compareTo);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            final int idx = findMinSize(entries, queries[i][1]);
            if (idx == rooms.length || idx == -1) {
                ans[i] = -1;
                continue;
            }
            ans[i] = minDiff(entries.get(idx).getValue(), queries[i][0]);
        }
        return ans;
    }

    private int minDiff(List<Integer> ids, int preferred) {
        if (ids.size() == 1) {
            return ids.get(0);
        }

        int left = 0, right = ids.size();
        while (left < right) {
            final int mid = (left + right) >> 1;
            final Integer integer = ids.get(mid);
            if (integer < preferred) {
                left = mid + 1;
            } else if (integer > preferred) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    private int findMinSize(ArrayList<Map.Entry<Integer, List<Integer>>> entries, int minSize) {
        int left = 0, right = entries.size() - 1;
        while (left < right) {
            final int mid = (left + right) >> 1;
            if (entries.get(mid).getKey() < minSize) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return entries.get(left).getKey() < minSize ? -1 : left;
    }

    public static void main(String[] args) {
        final int[] x = new Solution().closestRoom(new int[][]{{2, 2}, {1, 2}, {3, 2}}, new int[][]{{3, 1}, {3, 3}, {5, 2}});
        System.out.println(Arrays.toString(x));
    }
}