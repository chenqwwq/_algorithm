package top.chenqwwq.leetcode.daily._2025._20250224;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2025/2/24
 **/
public class OrderedStream {

    int ptr, n;
    String[] vals;

    public OrderedStream(int n) {
        this.vals = new String[n];
        this.ptr = 0;
        this.n = n;
    }

    public List<String> insert(int idKey, String value) {
        this.vals[idKey - 1] = value;
        if (ptr == idKey - 1) {
            List<String> ans = new ArrayList<>();
            int i = ptr;
            while (i < n && vals[i] != null) {
                ans.add(vals[i++]);
            }
            ptr = i;
            return ans;
        }
        return List.of();
    }
}