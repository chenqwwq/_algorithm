package top.chenqwwq.leetcode.daily._2022._20220629;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 沽酒
 * @date 2022/06/29
 */
public class Codec {
    Map<String, String> o2t = new HashMap<>(), t2o = new HashMap<>();

    Random random = new Random();
    String strs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    int k = 8;

    public String encode(String ori) {
        while (!o2t.containsKey(ori)) {
            char[] cs = new char[k];
            for (int i = 0; i < k; i++) {
                cs[i] = strs.charAt(random.nextInt(strs.length()));
            }
            String tiny = String.valueOf(cs);
            if (t2o.containsKey(tiny)) {
                continue;
            }
            o2t.put(ori, tiny);
            t2o.put(tiny, ori);
        }
        return o2t.get(ori);
    }

    public String decode(String shortUrl) {
        return t2o.get(shortUrl);
    }
}