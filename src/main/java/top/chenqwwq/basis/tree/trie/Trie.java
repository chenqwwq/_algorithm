package top.chenqwwq.basis.tree.Trie;

import java.util.Objects;

/**
 * // 前缀树
 *
 * @author chen
 * @date 2020/7/12 上午10:06
 */
public class Trie {
    /**
     * 子节点
     * child[i]表示(char)(i+'a')存在
     **/
    Trie[] child;

    /**
     * 是否存在单词
     */
    boolean isEnd;

    /**
     * 26个单词
     * <p>
     * 默认不成单词
     */
    public Trie() {
        child = new Trie[26];

        isEnd = false;
    }

    /**
     * 插入单词
     */
    public void insert(String word) {
        if (isEmpty(word)){
            return;
        }
        // 以当前节点为Root
        Trie curr = this;
        for (char c : word.toCharArray()) {
            final int idx = c - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Trie();
            }
            curr = curr.child[idx];
        }
        curr.isEnd = true;
    }

    public boolean isEmpty(String word){
        return Objects.isNull(word) || word.length() == 0;
    }

    /**
     * 查找是否存在
     */
    public boolean search(String word) {
        if (isEmpty(word)){
            return false;
        }

        Trie curr = this;
        for (char c : word.toCharArray()) {
            final int idx = c - 'a';
            if (curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx];
        }

        return curr.isEnd;
    }
}
