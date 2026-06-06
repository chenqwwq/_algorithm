package top.chenqwwq.leetcode.topic.graph.topological._207;

import java.util.*;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 *
 * @author chen
 * @date 2021/3/7
 **/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // prerequisites 相当于所有路径

        // 直接用List<List<Integer>>保存,后继节点
        List<Integer>[] hash = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            hash[i] = new ArrayList<>();
        }

        // 每个点的入度
        int[] in = new int[numCourses];

        // 保存临近点以及入度信息
        for (int[] prerequiste : prerequisites) {
            // 保存邻接列表
            hash[prerequiste[1]].add(prerequiste[0]);
            // 入度+1
            in[prerequiste[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 加入入度为0的节点
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.offer(i);
            }
        }

        // 借助队列的bfs
        while (!queue.isEmpty()) {
            Integer idx = queue.poll();
            in[idx] = -1;
            numCourses--;

            for (int i : hash[idx]) {
                if (--in[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return numCourses == 0;
    }
}
