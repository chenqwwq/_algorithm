package top.chenqwwq.leetcode.daily._20220711;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

/**
 * @author 沽酒
 * @since 2022/07/11
 */
public class MagicDictionary {
    MagicDictionary[] child;
    boolean end;

    public MagicDictionary() {
        child = new MagicDictionary[26];
        end = false;
    }

    private void insert(String word) {
        MagicDictionary cur = this;
        for (char c : word.toCharArray()) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new MagicDictionary();
            }
            cur = cur.child[c - 'a'];
        }
        cur.end = true;
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            insert(word);
        }
    }

    private boolean search(MagicDictionary node, String word, int pos) {
        final int n = word.length();
        if (pos > n) {
            return false;
        }
        for (int i = pos; i < n; i++) {
            char c = word.charAt(i);
            if (node.child[c - 'a'] == null) {
                return false;
            }
            node = node.child[c - 'a'];
        }
        return node.end;
    }

    private boolean find(MagicDictionary node, String word, int pos) {
        if (pos >= word.length()) {
            return false;
        }
        int p = word.charAt(pos) - 'a';
        for (int i = 0; i < 26; i++) {
            if (node.child[i] == null) {
                continue;
            }
            if (i == p) {
                if (find(node.child[i], word, pos + 1)) {
                    return true;
                }
            } else if (search(node.child[i], word, pos + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(String searchWord) {
        return find(this, searchWord, 0);
    }
}