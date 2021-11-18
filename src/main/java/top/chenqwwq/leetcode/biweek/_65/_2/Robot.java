package top.chenqwwq.leetcode.biweek._65._2;

/**
 * 第一次模拟失败
 * <p>
 * 直接转化为一维计算
 *
 * @author chen
 * @date 2021-11-15
 **/
public class Robot {

	String[] DIREC = new String[]{"East", "North", "West", "South"};
	final int width, height, total;
	int curr = 0;
	boolean start = false;

	public Robot(int width, int height) {
		this.width = width;
		this.height = height;
		this.total = 2 * width + 2 * height - 4;
	}


	public void move(int num) {
		start = true;
		curr = (curr + num) % total;
	}

	public int[] getPos() {
		// 6 3 14
		// curr < 6
		if (curr < width) {
			// curr,0
			return new int[]{curr, 0};
			// curr < 8
		} else if (curr < width + height - 1) {
			// 6 -> 5,1
			return new int[]{width - 1, curr - width + 1};
			// curr < 13
		} else if (curr < 2 * width + height - 2) {
			// 8 -> 4,2
			// 6 - (8 - 9 + 3)
			return new int[]{width - (curr - width - height + 3), height - 1};
		} else {
			// 13 ->
			return new int[]{0, height - (curr - 2 * width - height + 4)};
		}
	}

	public String getDir() {
		if (curr == 0) {
			return start ? DIREC[3] : DIREC[0];
		}
		if (curr < width) {
			return DIREC[0];
		} else if (curr < width + height - 1) {
			return DIREC[1];
		} else if (curr < 2 * width + height - 2) {
			return DIREC[2];
		} else {
			return DIREC[3];
		}
	}
}