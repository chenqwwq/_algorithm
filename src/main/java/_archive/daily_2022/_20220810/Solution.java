package top.chenqwwq.leetcode.daily._2022._20220810;

/**
 * @author 沽酒
 * @since 2022/08/10
 */
public class Solution {
    public String solveEquation(String equation) {
        equation = equation.replace("-", "+-");
        final String[] eq = equation.split("=");
        int[] ll = parse(eq[0]),rr = parse(eq[1]);
        int xl = ll[0], nl = ll[1], xr = rr[0], nr = rr[1];
        if (xl == xr &&  nl != nr) return "No solution";
        if (xl == xr) return "Infinite solutions";
        return "x=" + ((nr - nl) / (xl - xr));
    }

    private int[] parse(String ss){
        int[] ret = new int[2];
        for (String s : ss.split("\\+")) {
            if(s.isEmpty()) continue;
            if (s.contains("x")) {
                if("x".equals(s)) ret[0] += 1;
                else if("-x".equals(s))ret[0] -= 1;
                else ret[0] += Integer.parseInt(s.substring(0, s.length() - 1));

            }
            else ret[1] += Integer.parseInt(s);
        }
        return ret;
    }
}