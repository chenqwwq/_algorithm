package top.chenqwwq.leetcode.contest.weekly._312._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/9/25
 **/
public class Solution {
    class Obj {
        private String name;
        private int height;

        public Obj(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        final int n = names.length;
        Obj[] objs = new Obj[n];
        for (int i = 0; i < n; i++) objs[i] = new Obj(names[i], heights[i]);
        Arrays.sort(objs, (o1, o2) -> Integer.compare(o2.height,o1.height));
        String[] ans = new String[n];
        for(int i = 0;i < n;i++) ans[i] = objs[i].name;
        return ans;
    }
}