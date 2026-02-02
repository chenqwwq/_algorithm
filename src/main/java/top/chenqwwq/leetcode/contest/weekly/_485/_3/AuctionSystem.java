package top.chenqwwq.leetcode.contest.weekly._485._3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2026/1/18
 **/
public class AuctionSystem {

    public static void main(String[] args) {
        final AuctionSystem ac = new AuctionSystem();
        ac.addBid(9, 10, 9);
        ac.removeBid(9, 10);
        System.out.println(ac.getHighestBidder(10));
    }

    final Map<Integer, Map<Integer, Integer>> data = new HashMap<>();

    Map<Integer, PriorityQueue<int[]>> queue = new HashMap<>();

    public AuctionSystem() {

    }

    public void addBid(int userId, int itemId, int bidAmount) {
        updateBid(userId, itemId, bidAmount);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        Map<Integer, Integer> items2Bids = data.getOrDefault(userId, new HashMap<>());
        items2Bids.put(itemId, newAmount);
        data.put(userId, items2Bids);

        if (newAmount != -1) {

            final PriorityQueue<int[]> q = queue.getOrDefault(itemId, new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return Integer.compare(o2[1], o1[1]);
                    }
                    return Integer.compare(o2[0], o1[0]);
                }
            }));
            q.offer(new int[]{newAmount, userId});
            queue.put(itemId, q);
        }
    }

    public void removeBid(int userId, int itemId) {
        updateBid(userId, itemId, -1);
    }

    public int getHighestBidder(int itemId) {
        if (!queue.containsKey(itemId)) {
            return -1;
        }
        final PriorityQueue<int[]> queue = this.queue.get(itemId);
        int[] q;
        while (!queue.isEmpty() && (q = queue.peek())[0] != data.get(q[1]).get(itemId)) {
            queue.poll();
        }

        return queue.isEmpty() ? -1 : queue.peek()[1];

    }
}