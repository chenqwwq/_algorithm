package top.chenqwwq.pat.advanced._1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chen
 * @date 2021-04-21
 **/
public class Main {
    static class Record {
        int time;
        int day;
        int hour;
        int minute;
        boolean isOnline;

        public Record(int time, int day, int hour, int minute, boolean isOnline) {
            this.time = time;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.isOnline = isOnline;
        }
    }

    static final Comparator<Record> SORT = Comparator.comparingInt(o -> o.time);
    static int[] toll = new int[24];
    static int[] prefix = new int[25];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String line = reader.readLine();
        final long l = System.currentTimeMillis();
        final String[] firstLine = line.split(" ");
        prefix[0] = 0;
        for (int i = 0; i < 24; i++) {
            toll[i] = Integer.parseInt(firstLine[i]);
            prefix[i + 1] = prefix[i] + (60 * toll[i]);
        }
        int month = 0;
        final int recordCnt = Integer.parseInt(reader.readLine());
        Map<String, PriorityQueue<Record>> hash = new HashMap<>();
        for (int i = 0; i < recordCnt; i++) {
            final String[] record = reader.readLine().split(" ");
            final PriorityQueue<Record> value = hash.getOrDefault(record[0], new PriorityQueue<>(SORT));
            final String[] split = record[1].split(":");
            if (i == 0) {
                month = Integer.parseInt(split[0]);
            }
            final int day = Integer.parseInt(split[1]);
            final int hour = Integer.parseInt(split[2]);
            final int minute = Integer.parseInt(split[3]);
            final int time = day * 24 * 60 + hour * 60 + minute;
            value.add(new Record(time, day, hour, minute, "on-line".equals(record[2])));
            hash.put(record[0], value);
        }
        List<String> names = new ArrayList<>(hash.keySet());
        Collections.sort(names);
        for (String name : names) {
            float totalMount = 0L;
            final PriorityQueue<Record> records = hash.get(name);
            System.out.printf("%s %02d\n", name, month);
            Record online = null;
            while (!records.isEmpty()) {
                final Record record = records.poll();
                if (record.isOnline) {
                    online = record;
                    continue;
                }
                if (online == null) {
                    continue;
                }
                // 计算当前话费
                final double charge = (record.day * prefix[24] + prefix[record.hour] + toll[record.hour] * record.minute
                        - (online.day * prefix[24] + prefix[online.hour] + toll[online.hour] * online.minute)) / 100d;
                System.out.printf("%02d:%02d:%02d %02d:%02d:%02d %d $%.2f\n", online.day, online.hour, online.minute, record.day, record.hour, record.minute, record.time - online.time, charge);
                totalMount += charge;
                online = null;
            }
            System.out.printf("Total amount: $%.2f\n", totalMount);
        }
        reader.close();
    }
}
