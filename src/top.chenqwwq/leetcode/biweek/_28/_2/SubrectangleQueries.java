package top.chenqwwq.leetcode.biweek._28._2;

/**
 * 5422. 子矩形查询 显示英文描述
 * <p>
 * 请你实现一个类 SubrectangleQueries ，它的构造函数接收 rows x cols 的整数矩阵，并支持以下两种操作：
 * <p>
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 * <p>
 * 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
 * 2. getValue(int row, int col)
 * <p>
 * 返回矩形中坐标 (row,col) 的当前值。
 * <p>
 * 提示：
 * <p>
 * 最多有 500 次updateSubrectangle 和 getValue 操作。
 * 1 <= rows, cols <= 100
 * rows == rectangle.length
 * cols == rectangle[i].length
 * 0 <= row1 <= row2 < rows
 * 0 <= col1 <= col2 < cols
 * 1 <= newValue, rectangle[i][j] <= 10^9
 * 0 <= row < rows
 * 0 <= col < cols
 *
 * @author chen
 * @date 2020/6/13 下午10:40
 */
public class SubrectangleQueries {

    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
