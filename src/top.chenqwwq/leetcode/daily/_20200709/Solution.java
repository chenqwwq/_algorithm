package top.chenqwwq.leetcode.daily._20200709;

/**
 * 面试题 17.13. 恢复空格
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"
 * 已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。
 * 当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 *
 * @author chen
 * @date 2020-07-09
 **/
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        // 异常情况
        if (dictionary == null || dictionary.length == 0) {
            return sentence.length();
        }
        if (sentence == null || sentence.length() == 0) {
            return 0;
        }

        // 因为涉及到搜索,直接采用前缀树
        // 构造前缀树
        Trie root = new Trie();
        for (String s : dictionary) {
            root.insert(s);
        }

        // dp[i]表示0~i-1最少的空闲字符
        // dp[i]可以往前遍历
        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;

        for (int i = 1; i <= sentence.length(); i++) {
            // 往前推进一个字符，最多就是多一个空闲字符
            dp[i] = dp[i - 1] + 1;
            Trie curr = root;
            // 这里是从后往前遍历
            for (int j = i; j >= 1; j--) {
                int idx = sentence.charAt(j - 1) - 'a';
                // 如果该节点不存在于字典树，直接退出
                // 当前节点的空闲字符就是+1
                if (curr.child[idx] == null) {
                    break;
                }

                // 如果字符存在，并且为末尾字符，则计算当前的空闲字符
                // dp[j-1]表示当前
                if (curr.child[idx].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }

                // 完全匹配的时候直接退出
                if (dp[i] == 0) {
                    break;
                }

                // 存在字符但不是末尾，则将字符往后推进
                curr = curr.child[idx];
            }
        }
        return dp[sentence.length()];
    }

    class Trie {
        public Trie[] child;
        public boolean isEnd;

        public Trie() {
            child = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie curPos = this;

            for (int i = s.length() - 1; i >= 0; --i) {
                int t = s.charAt(i) - 'a';
                if (curPos.child[t] == null) {
                    curPos.child[t] = new Trie();
                }
                curPos = curPos.child[t];
            }
            curPos.isEnd = true;
        }
    }
}

