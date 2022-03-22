package top.chenqwwq.leetcode.weekly._yinglian;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/3/13
 **/
public class DiscountSystem {

    Map<Integer, Map<Integer, Integer>> userActivityCnt;
    Map<Integer, Set<Integer>> activityUser;
    List<Integer[]> activities;
    Set<Integer> delActId;

    public DiscountSystem() {
        delActId = new HashSet<>();
        activities = new ArrayList<>();
        activityUser = new HashMap<>();
        userActivityCnt = new HashMap<>();
    }

    public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
        if (delActId.contains(actId)) {
            delActId.remove(actId);
        } else {
            activities.add(new Integer[]{actId, priceLimit, discount, number, userLimit});
            activities.sort((o1, o2) -> {
                if (Objects.equals(o2[2], o1[2])) {
                    return o1[0].compareTo(o2[0]);
                }
                return o2[2].compareTo(o1[2]);
            });
            activityUser.put(actId, new HashSet<>());
        }
    }

    public void removeActivity(int actId) {
        delActId.add(actId);
    }

    public int consume(int userId, int cost) {
        for (Integer[] activity : activities) {
            Integer actId = activity[1];
            if (cost < actId || delActId.contains(actId)) {
                continue;
            }
            if (!activityUser.get(actId).contains(userId) && activityUser.get(actId).size() >= activity[3]) {
                continue;
            }
            activityUser.get(actId).add(userId);
            Map<Integer, Integer> map = userActivityCnt.get(userId);
            Integer cnt = map.getOrDefault(actId, 0);
            if (cnt > activity[4]) {
                continue;
            }
            map.put(actId, cnt + 1);
            return cost - activity[2];
        }
        return cost;
    }

    public static void main(String[] args) {
        DiscountSystem ds = new DiscountSystem();
        ds.addActivity(1,15,5,7,2);
        System.out.println(ds.consume(101,16));
        ds.removeActivity(1);
        System.out.println(ds.consume(101,19));
    }
}