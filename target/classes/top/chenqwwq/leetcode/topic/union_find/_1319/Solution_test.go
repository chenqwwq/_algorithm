package _1319

import "testing"

/**
  @user: chenqwwq
  @date: 2020/12/31
*/

func Test_makeConnected(t *testing.T) {
	type args struct {
		n           int
		connections [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例 1：
		输入：n = 4, connections = [[0,1],[0,2],[1,2]]
		输出：1
		解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
		示例 2：
		输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
		输出：2
		示例 3：
		输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
		输出：-1
		解释：线缆数量不足。
		示例 4：
		输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
		输出：0
		*/
		{
			name: "1",
			args: args{4, [][]int{{0, 1}, {0, 2}, {1, 2}}},
			want: 1,
		},
		{
			name: "2",
			args: args{6, [][]int{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}},
			want: 2,
		},
		{
			name: "3",
			args: args{6, [][]int{{0, 1}, {0, 2}, {0, 3}, {1, 2}}},
			want: -1,
		},
		{
			name: "4",
			args: args{5, [][]int{{0, 1}, {0, 2}, {3, 4}, {2, 3}}},
			want: 0,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := makeConnected(tt.args.n, tt.args.connections); got != tt.want {
				t.Errorf("makeConnected() = %v, want %v", got, tt.want)
			}
		})
	}
}
