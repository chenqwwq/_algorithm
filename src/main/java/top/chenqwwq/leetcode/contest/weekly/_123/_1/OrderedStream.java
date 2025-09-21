package top.chenqwwq.leetcode.contest.weekly._123._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2020/11/15
 **/
public class OrderedStream {

    String[] values;
    int ptr;

    private List<String> EMPTY = new ArrayList<>(0);

    public OrderedStream(int n) {
        this.values = new String[n];
        this.ptr = 1;
    }

    public List<String> insert(int id, String value) {
        values[id - 1] = value;

        if (values[ptr - 1] != null) {
            List<String> ans = new ArrayList<>();
            int start = ptr - 1;
            while (start < values.length && values[start] != null) {
                ans.add(values[start++]);
            }
            ptr = start + 1;
            return ans;
        }

        return EMPTY;
    }
}

