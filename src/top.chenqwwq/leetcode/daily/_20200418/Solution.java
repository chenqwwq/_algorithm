package top.chenqwwq.leetcode.daily._20200418;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * {@see https://top.chenqwwq.leetcode-cn.com/problems/container-with-most-water/}
 * <p>
 * 输出：49
 *
 * @author chen
 * @date 2020/4/18 下午2:27
 */
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        // 双指针遍历
        int left = 0, right = height.length - 1;
        int resArea = getArea(height, left, right);

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

            resArea = Math.max(getArea(height, left, right), resArea);
        }

        return resArea;
    }

    /**
     * 获取容器当前盛水面积
     */
    private int getArea(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}

