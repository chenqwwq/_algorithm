package top.chenqwwq.leetcode.daily._20220907;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2022/9/7
 **/
public class Solution {
    public String reorderSpaces(String text) {
        final int n = text.length();
        String[] afSp = text.split(" ");
        List<String> words = new ArrayList<>();
        int m = n;
        for (String s : afSp) {
            if (Objects.equals(s, "")) {
                continue;
            }
            words.add(s);
            m -= s.length();
        }
        int k = m / Math.max(1,words.size() - 1);
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word);
            for(int i = 0;m-- > 0 && i < k;i++){
                sb.append(" ");
            }
        }
        while (m-- > 0){
            sb.append(" ");
        }
        return sb.toString();
    }

}