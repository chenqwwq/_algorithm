package top.chenqwwq.leetcode.daily._20201105;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * @author chen
 * @date 2020-11-05
 **/
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 基础实现一个bfs
        // 广度优先搜索遍历

        // wordList的访问标记
        boolean[] visited = new boolean[wordList.size()];

        // 借助Queue完成BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        final int firstIndex = wordList.indexOf(beginWord);
        if (firstIndex != -1) {
            visited[firstIndex] = true;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int tmpSize = queue.size();
            for (int i = 0; i < tmpSize; i++) {
                final String poll = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited[j]) {
                        continue;
                    }

                    final String des = wordList.get(j);
                    if (!check(poll, des)) {
                        continue;
                    }

                    if (des.equals(endWord)) {
                        return ans + 1;
                    }

                    visited[j] = true;
                    queue.offer(des);
                }

            }
        }
        return 0;
    }


    /**
     * 检查是否可以覆盖
     * <p>
     * src和des只能有一个字母不一样
     */
    private boolean check(String src, String des) {
        if (src.length() != des.length()) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) != des.charAt(i)) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
}