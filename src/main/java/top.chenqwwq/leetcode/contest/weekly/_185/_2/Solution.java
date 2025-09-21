package top.chenqwwq.leetcode.contest.weekly._185._2;

import java.util.*;

/**
 * @author chen
 * @date 2020/4/19 上午11:35
 */
public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodSet = new HashSet<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();
        // 遍历出菜名和每桌客户的点菜数目
        for (List<String> order : orders) {
            // 桌名
            String table = order.get(1);
            // 菜名
            String food = order.get(2);
            // 添加到食品集合
            foodSet.add(food);
            // 添加到桌号的菜单中
            final Map<String, Integer> foodMapForTable = map.getOrDefault(table, new HashMap<>());
            foodMapForTable.put(food, foodMapForTable.getOrDefault(food, 0) + 1);
            map.put(table, foodMapForTable);
        }

        List<List<String>> res = new ArrayList<>();

        // 提取菜名并排序
        final ArrayList<String> foodList = new ArrayList<>(foodSet);
        foodList.sort(Comparator.naturalOrder());
        foodList.add(0, "Table");
        res.add(foodList);

        // 提取桌号,并排序
        final Set<String> tableSet = map.keySet();
        final ArrayList<String> tables = new ArrayList<>(tableSet);
        tables.sort(Comparator.comparing(a -> a.substring(0, 1)));

        for (String table : tables) {
            // 某桌的菜单
            List<String> tableFood = new ArrayList<>();
            tableFood.add(table);
            final Map<String, Integer> fondMap = map.get(table);
            for (int i = 1; i < foodList.size(); i++) {
                tableFood.add(fondMap.getOrDefault(foodList.get(i), 0).toString());
            }
            res.add(tableFood);
        }

        return res;
    }
}