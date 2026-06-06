package top.chenqwwq.pat.advanced._1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/3/27
 **/
public class Main {

    private static final String IMPOSSIBLE = "Impossible";

    public static void main(String[] args) throws IOException {
        // 尝试用二分
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final String[] split = in.readLine().split(" ");
        in.close();

        String N1 = split[0], N2 = split[1];
        int tag = Integer.parseInt(split[2]), radix = Integer.parseInt(split[3]);

        // 转化为10进制处理
        final boolean isTag = tag == 1;
        final String src = isTag ? N2 : N1;
        final long target = isTag ? getNum(N1, radix) : getNum(N2, radix);

        // 找到最小和最大的进制
        char lc = src.charAt(0);
        for (char s : src.toCharArray()) {
            if (s > lc) {
                lc = s;
            }
        }
        long low = (lc >= 97 ? lc - 'a' + 10 : lc - '0') + 1, high = Math.max(target, low);

        while (low <= high) {
            long mid = (low + high) >> 1;
            final long num = getNum(src, mid);
            if (num < 0 || num > target) {
                high = mid - 1;
            } else if (num < target) {
                low = mid + 1;
            } else {
                System.out.printf("%d\n", mid);
                return;
            }
        }
        System.out.printf("%s\n", IMPOSSIBLE);
    }

    private static long getNum(final String str, long radix) {
        final char[] chars = str.toCharArray();
        int r = 0;
        long ans = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            final int num = chars[i] >= 97 ? chars[i] - 'a' + 10 : chars[i] - '0';
            ans += num * Math.pow(radix, r++);
            if (ans < 0) {
                return -1;
            }
        }
        return ans;
    }
}
