package top.chenqwwq.leetcode.contest.biweek._147._2;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2025/1/4
 **/
public class TaskManager {

    //  priority -> [taskId,userId]
    private TreeMap<Integer, TreeMap<Integer, Integer>> priority2TaskId2UserId = new TreeMap<>();
    private Map<Integer, Integer> taskId2Priority = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        // [userId, taskId, priority]
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskId2Priority.put(taskId, priority);
        final TreeMap<Integer, Integer> treeMap = priority2TaskId2UserId.getOrDefault(priority, new TreeMap<>());
        treeMap.put(taskId, userId);
        priority2TaskId2UserId.put(priority, treeMap);
    }

    public void edit(int taskId, int newPriority) {
        // 按照 taskId 找到对象
        // 修改优先级修改排序
        final Integer priority = taskId2Priority.remove(taskId);
        final Integer userId = priority2TaskId2UserId.get(priority).remove(taskId);
        if(priority2TaskId2UserId.get(priority).isEmpty()) priority2TaskId2UserId.remove(priority);
        add(userId, taskId, newPriority);
    }

    public void rmv(int taskId) {
        // 删除 taskId 对应任务
        final Integer priority = taskId2Priority.remove(taskId);
        priority2TaskId2UserId.get(priority).remove(taskId);
        if (priority2TaskId2UserId.get(priority).isEmpty()) priority2TaskId2UserId.remove(priority);
    }

    public int execTop() {
        // 执行最高优先级的任务
        if (taskId2Priority.isEmpty()) return -1;
        final Map.Entry<Integer, Integer> taskId2UserId = priority2TaskId2UserId.lastEntry().getValue().lastEntry();
        rmv(taskId2UserId.getKey());
        return taskId2UserId.getValue();
    }

    public static void main(String[] args) {
        final TaskManager taskManager = new TaskManager(List.of(List.of(1,101,10),List.of(2,102,20),List.of(3,103,15)));
        taskManager.add(4,104,5);
        taskManager.edit(102,8);
        System.out.println(taskManager.execTop());
        taskManager.rmv(101);
        taskManager.add(5,105,15);
        System.out.println(taskManager.execTop());
    }
}