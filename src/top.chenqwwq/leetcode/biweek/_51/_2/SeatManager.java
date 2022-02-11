package top.chenqwwq.leetcode.biweek._51._2;

/**
 * @author chen
 * @date 2021/5/1
 **/
public class SeatManager {

    boolean[] seat;
    int min;

    public SeatManager(int n) {
        seat = new boolean[n + 1];
        min = 1;
    }

    public int reserve() {
        int ans = min;
        seat[ans] = true;
        for (int i = 1; i < seat.length; i++) {
            if (!seat[i]) {
                min = i;
                break;
            }
        }
        return ans;
    }

    public void unreserve(int seatNumber) {
        seat[seatNumber] = false;
        if (min > seatNumber) {
            min = seatNumber;
        }
    }
}
