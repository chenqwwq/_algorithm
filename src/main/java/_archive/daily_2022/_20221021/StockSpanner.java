package top.chenqwwq.leetcode.daily._2022._20221021;

/**
 * @author chenqwwq
 * @date 2022/10/22
 **/
public class StockSpanner {
    int N = (int) 1e4 + 10;
    int[][] stack = new int[N][2];
    int p = -1,i = -1;

    public StockSpanner() {
    }

    public int next(int price) {
        // 构造单调递增序列
        // 弹出所有比当前值小的数
        while (p != -1 && stack[p][1] <= price) p--;
        i++;
        int ans = p == -1 ? 1 :  i - stack[p][0];
        stack[++p][0] = i;
        stack[p][1] = price;
        return ans;
    }

    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        ss.next(100);
        ss.next(80);
        ss.next(60);
        ss.next(70);
        ss.next(60);
        ss.next(75);
        ss.next(85);
    }
}