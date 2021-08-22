package top.chenqwwq.basis.unionfind;

/**
 * 并查集合的Java实现
 *
 * @author chen
 * @date 2021-06-08
 **/
public class UnionFind {
	/**
	 * 必要时候可以使用 Map 等数据结构代替,数组是以下标作为元素标识
	 */
	public int[] data;

	public UnionFind(int size) {
		this.data = new int[size];
		for (int i = 0; i < size; i++) {
			data[i] = i;
		}
	}

	/**
	 * 附带路径压缩的查找
	 */
	public int compressionFind(int i) {
		if (data[i] != i) {
			data[i] = compressionFind(data[i]);
		}
		return data[i];
	}

	public void merge(int i, int j) {
		final int x = compressionFind(i), y = compressionFind(j);
		if (x != y) {
			data[x] = y;
		}
	}
}
