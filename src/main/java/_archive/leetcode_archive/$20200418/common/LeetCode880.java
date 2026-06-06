package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @description
 * @email ai654778@vip.qq.com
 * @date 19-1-26
 */
public class LeetCode880 {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeAtIndex("a23", 6));
    }

    static class Solution {
        // 展开字符串S会导致内存溢出
//        public String decodeAtIndex(String S, int K) {
//            StringBuilder res = new StringBuilder();
//            final char[] chars = S.toCharArray();
//
//            for (char c : chars){
//                if(Character.isDigit(c)){
//                    for (int i = 0;i < (int)c;i++){
//                        res.append(res);
//                    }
//                }
//                if(Character.isLetter(c)){
//                    res.append(c);
//                }
//            }
//            return ""+res.toString().charAt(K);
//        }
        public String decodeAtIndex(String S, int K) {
            final char[] chars = S.toCharArray();
            // 记录每个字母对应的解码长度
            int[] length = new int[chars.length + 1];
            // 计算总长度
            int i = 0;
            for (; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    length[i + 1] = (chars[i] - '0') * length[i];
                } else {
                    length[i + 1] = length[i] + 1;
                }
                // 连续数组无法判断,移出此判断
//                if(length[i+1] == K){
//                    if(Character.isDigit(chars[i])){
//                        return chars[i-1]+"";
//                    }else {
//                        return chars[i]+"";
//                    }
//                }
                // 排除为字母的情况,只有在i为数字位的时候才会直接大于
                if (length[i + 1] >= K) {
                    break;
                }
            }

            while (true) {
                int j = 1;
                while (length[j] < K) {
                    j++;
                }
                char c = chars[j - 1];
                if (Character.isDigit(c)) {
                    while (length[i - 1] < K) {
                        K -= length[i - 1];
                    }
                } else {
                    return c + "";
                }
            }

        }
    }
}
