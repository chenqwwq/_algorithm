package top.chenqwwq.leetcode.contest.weekly._317._2;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/10/30
 **/
//public class Solution {
//
//    class Obj {
//        String creator;
//        int maxView = 0;
//        int total = 0;
//        Map<Integer, List<String>> view2Id = new HashMap<>();
//
//
//        public Obj(String name) {
//            this.creator = name;
//        }
//    }
//
//    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
//        final int n = creators.length;
//        Map<String, Obj> map = new HashMap<>();
//        int max = 0;
//        List<String> names = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            String creator = creators[i];
//            if (!map.containsKey(creator)) map.put(creator, new Obj(creator));
//            Obj obj = map.get(creator);
//            if (!obj.view2Id.containsKey(views[i])) obj.view2Id.put(views[i], new ArrayList<>());
//            obj.view2Id.get(views[i]).add(ids[i]);
//            obj.total += views[i];
//            if (views[i] > obj.maxView) obj.maxView = views[i];
//            if (obj.total > max) {
//                max = obj.total;
//                names.clear();
//                names.add(obj.creator);
//            } else if (obj.total == max) {
//                names.add(obj.creator);
//            }
//        }
//
//        List<List<String>> ans = new ArrayList<>(names.size());
//        for(String name : names){
//            Obj obj = map.get(name);
//            List<String> all = obj.view2Id.get(obj.maxView);
//            all.sort(String::compareTo);
//            ans.add(List.of(name,all.get(0)));
//        }
//        return ans;
//    }
//}