package _1277

import "testing"

/**
  @user: chenqwwq
  @date: 2020/8/13
*/

func Test_countSquares(t *testing.T) {
	type args struct {
		matrix [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例 1：

		输入：matrix =
		[
		  [0,1,1,1],
		  [1,1,1,1],
		  [0,1,1,1]
		]
		输出：15
		解释：
		边长为 1 的正方形有 10 个。
		边长为 2 的正方形有 4 个。
		边长为 3 的正方形有 1 个。
		正方形的总数 = 10 + 4 + 1 = 15.
		示例 2：


		输入：matrix =
		[
		  [1,0,1],
		  [1,1,0],
		  [1,1,0]
		]
		输出：7
		解释：
		边长为 1 的正方形有 6 个。
		边长为 2 的正方形有 1 个。
		正方形的总数 = 6 + 1 = 7.
		*/

		{
			name: "case1",
			args: args{
				matrix: [][]int{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}},
			},
			want: 15,
		},
		{
			name: "case1",
			args: args{
				matrix: [][]int{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}},
			},
			want: 7,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := countSquares(tt.args.matrix); got != tt.want {
				t.Errorf("countSquares() = %v, want %v", got, tt.want)
			}
		})
	}
}
