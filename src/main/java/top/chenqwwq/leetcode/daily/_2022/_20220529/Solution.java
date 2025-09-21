package top.chenqwwq.leetcode.daily._2022._20220529;

/**
 * @author chenqwwq
 * @date 2022/5/29
 **/
public class Solution {
    public String validIPAddress(String queryIP) {
        return queryIP.contains(":") ? checkV6(queryIP) : checkV4(queryIP);
    }

    String checkV6(String ip) {
        String[] split = ip.split("\\:");
        if (split.length != 8) {
            return "Neither";
        }
        for (int i = 0; i < 8; i++) {
            if (split[i].length() > 4 || split[i].length() < 1) {
                return "Neither";
            }
            int num = Integer.parseInt(split[i], 16);
            if (num < 0 || num > 0xffff) {
                return "Neither";
            }
        }
        return "IPv6";
    }


    String checkV4(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return "Neither";
        }
        for (int i = 0; i < 4; i++) {
            if (split[i].length() > 3 || split[i].length() < 1) {
                return "Neither";
            }
            int num = Integer.parseInt(split[i]);
            if (num > 255 || num < 0) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public static void main(String[] args) {
        new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }
}