package top.chenqwwq.leetcode.contest.biweek._152._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/3/15
 **/
public class Spreadsheet {

    Map<String, Integer> map = new HashMap<>();
    int rows = 0;

    public Spreadsheet(int rows) {
        this.rows = rows;
    }

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.put(cell, 0);
    }

    public int getValue(String formula) {
        formula = formula.replace("=", "");
        final String[] sp = formula.split("\\+");
        int n1 = 0, n2 = 0;
        if (sp[0].charAt(0) >= 'A' && sp[0].charAt(0) <= 'Z') {
            n1 = map.getOrDefault(sp[0], 0);
        } else {
            n1 = Integer.parseInt(sp[0]);
        }

        if (sp[1].charAt(0) >= 'A' && sp[1].charAt(0) <= 'Z') {
            n2 = map.getOrDefault(sp[1], 0);
        } else {
            n2 = Integer.parseInt(sp[1]);
        }

        return n1 + n2;
    }
}