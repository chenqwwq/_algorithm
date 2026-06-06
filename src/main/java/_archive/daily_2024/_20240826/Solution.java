package top.chenqwwq.leetcode.daily._2024._20240826;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/8/26
 **/
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        final Map<Integer, Employee> id2Employee = new HashMap<>();

        for (Employee employee : employees) {
            id2Employee.put(employee.id, employee);
        }

        return handle(id2Employee, id);

    }

    public int handle(Map<Integer, Employee> map, Integer id) {
        final Employee employee = map.get(id);
        int ans = employee.importance;
        if (employee.subordinates == null || employee.subordinates.isEmpty()) return ans;
        for (Integer next : employee.subordinates) {
            ans += handle(map, next);
        }
        return ans;
    }

}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};