package top.chenqwwq.leetcode.biweek._83._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/7/23
 **/
public class NumberContainers {

    Map<Integer, TreeSet<Integer>> datas;
    Map<Integer, Integer> index2Number;

    public NumberContainers() {
        datas = new HashMap<>();
        index2Number = new HashMap<>();
    }

    public void change(int index, int number) {
        if(index2Number.containsKey(index)){
            int old = index2Number.get(index);
            datas.get(old).remove(index);
        }
        index2Number.put(index,number);
        if(!datas.containsKey(number)){
            datas.put(number,new TreeSet<>());
        }
        datas.get(number).add(index);
    }

    public int find(int number) {
        if(!datas.containsKey(number) || datas.get(number).isEmpty()){
            return -1;
        }
        return datas.get(number).first();
    }
}