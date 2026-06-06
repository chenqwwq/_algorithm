package top.chenqwwq.leetcode.daily._2024._20241008;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2024/10/8
 **/
public class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> all = new HashSet<>(),out = new HashSet<>();
        for(List<String> path : paths){
            all.addAll(path);
            out.add(path.get(0));
        }
        all.removeAll(out);
        return new ArrayList<>(all).get(0);
    }
}