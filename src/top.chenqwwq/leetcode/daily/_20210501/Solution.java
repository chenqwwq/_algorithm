package top.chenqwwq.leetcode.daily._20210501;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author chen
 * @date 2021/5/2
 **/
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // 转存
        Map<Integer, Employee> hash = new HashMap<>();
        for (Employee employee : employees) {
            hash.put(employee.id, employee);
        }

        // 初始
        Stack<Integer> stack = new Stack<>();
        stack.add(id);

        int ans = 0;
        while (!stack.empty()) {
            final Integer pop = stack.pop();
            final Employee employee = hash.get(pop);
            ans += employee.importance;
            stack.addAll(employee.subordinates);
        }
        return ans;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};