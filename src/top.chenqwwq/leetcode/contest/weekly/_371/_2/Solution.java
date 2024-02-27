package top.chenqwwq.leetcode.contest.weekly._371._2;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

/**
 * @author chenqwwq
 * @date 2023/11/12
 **/
public class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> at : access_times) {
            if (!map.containsKey(at.get(0))) map.put(at.get(0), new ArrayList<>());
            final List<String> list = map.get(at.get(0));
            list.add(at.get(1));
            map.put(at.get(0), list);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            final List<String> value = entry.getValue();
            value.sort(String::compareTo);
            Deque<Integer> deque = new LinkedList<>();
            for (String s : value) {
                final int num = get(s);
                deque.addLast(num);
                while (!deque.isEmpty() && num - deque.getFirst() >= 60)   deque.removeFirst();
                if(deque.size() >=3){
                    ans.add(entry.getKey());
                    break;
                }
            }
        }
        return ans;
    }

    private int get(String s) {
        return (get(s.charAt(0)) * 10 + get(s.charAt(1))) * 60 + (get(s.charAt(2)) * 10 + get(s.charAt(3)));
    }


    private int get(char c) {
        return c - '0';
    }
}