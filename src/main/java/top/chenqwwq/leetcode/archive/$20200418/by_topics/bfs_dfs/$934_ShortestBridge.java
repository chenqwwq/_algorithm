package top.chenqwwq.leetcode.archive.$20200418.by_topics.bfs_dfs;

import java.util.LinkedList;

/**
 * 934. Shortest Bridge
 * Medium
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * <p>
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * <p>
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 *
 * @author chen
 * @date 2019/10/20 下午5:48
 */
public class $934_ShortestBridge {
//    public static void main(String[] args) {
//        System.out.println(new $934_ShortestBridge().new Solution().shortestBridge(new int[][]{{0, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0}}));
//    }

    class Solution {
        public int shortestBridge(int[][] A) {

            int xLen = A.length, yLen = A[0].length;

            // 第一轮遍历找到一个岛屿的起点
            LinkedList<Point> queue = new LinkedList<>(), queue2 = new LinkedList<>();
            // BFS
            outer:
            for (int i = 0; i < xLen; i++) {
                for (int j = 0; j < yLen; j++) {
                    // 找到岛屿的起点
                    if (A[i][j] == 1) {
                        queue.add(new Point(i, j));
                        break outer;
                    }
                }
            }

            // 从起点开始BFS整个数组,将遍历到的第一座岛屿全部变为2
            while (!queue.isEmpty()) {
                Point poll = queue.poll();
                A[poll.i][poll.j] = 2;
                if (poll.j + 1 < yLen && A[poll.i][poll.j + 1] == 1) {
                    queue.offer(new Point(poll.i, poll.j + 1));
                }

                if (poll.j - 1 >= 0 && A[poll.i][poll.j - 1] == 1) {
                    queue.offer(new Point(poll.i, poll.j - 1));
                }
                if (poll.i + 1 < xLen && A[poll.i + 1][poll.j] == 1) {
                    queue.offer(new Point(poll.i + 1, poll.j));
                }
            }

            // 将第二层岛全部入队列
            for (int i = 0; i < xLen; i++) {
                for (int j = 0; j < yLen; j++) {
                    // 找到岛屿的起点
                    if (A[i][j] == 1) {
                        Point e = new Point(i, j);
                        queue2.add(e);
                        A[i][j] = -1;
                    }
                }
            }


            // 从起点开始BFS
            // 岛二向外扩散
            int size = queue2.size(), res = 0;
            while (!queue2.isEmpty()) {
                Point poll = queue2.poll();
                size--;
                if (A[poll.i][poll.j] == 2) {
                    return Math.max((res - 1), 1);
                }
                A[poll.i][poll.j] = -1;
                if (poll.j + 1 < yLen && A[poll.i][poll.j + 1] != -1) {
                    Point e = new Point(poll.i, poll.j + 1);
                    queue2.offer(e);
                }
                if (poll.j - 1 >= 0 && A[poll.i][poll.j - 1] != -1) {
                    Point e = new Point(poll.i, poll.j - 1);
                    queue2.offer(e);
                }
                if (poll.i - 1 >= 0 && A[poll.i - 1][poll.j] != -1) {
                    Point e = new Point(poll.i - 1, poll.j);
                    queue2.offer(e);
                }
                if (poll.i + 1 < xLen && A[poll.i + 1][poll.j] != -1) {
                    Point e = new Point(poll.i + 1, poll.j);
                    queue2.offer(e);
                }

                if (size == 0) {
                    size = queue2.size();
                    res++;
                }
            }

            return Math.max((res - 1), 1);
        }

        class Point {
            int i;
            int j;

            Point(int i, int j) {
                this.i = i;
                this.j = j;
            }

        }
    }
}
