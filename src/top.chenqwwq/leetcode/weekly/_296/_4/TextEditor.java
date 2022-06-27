package top.chenqwwq.leetcode.weekly._296._4;

/**
 * @author chenqwwq
 * @date 2022/6/5
 **/
public class TextEditor {
    StringBuilder data = new StringBuilder();
    int pos = 0;

    public TextEditor() {

    }

    public void addText(String text) {
        data.insert(pos,text);
        pos += text.length();
    }

    public int deleteText(int k) {
        int t = Math.max(pos - k, 0);
        data.delete(t, pos);
        int ret = pos - t;
        pos = t;
        return ret;
    }

    public String cursorLeft(int k) {
        pos = Math.max(0, pos - k);
        return data.substring(Math.max(0, pos - 10), pos);
    }

    public String cursorRight(int k) {
        pos = Math.min(data.length(), pos + k);
        return data.substring(Math.max(0, pos - 10), pos);
    }
}