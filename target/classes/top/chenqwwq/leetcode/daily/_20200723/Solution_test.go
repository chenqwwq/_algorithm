package _20200723

import "testing"

/**
  @user: chenqwwq
  @date: 2020/7/23
*/

func Test_minPathSum(t *testing.T) {
	type args struct {
		grid [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例:
		输入:
		[
		  [1,3,1],
		  [1,5,1],
		  [4,2,1]
		]
		输出: 7
		解释: 因为路径 1→3→1→1→1 的总和最小。
		*/
		{
			name: "simple",
			args: args{
				[][]int{
					{1, 3, 1},
					{1, 5, 1},
					{4, 2, 1},
				},
			},
			want: 7,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minPathSum(tt.args.grid); got != tt.want {
				t.Errorf("minPathSum() = %v, want %v", got, tt.want)
			}
		})
	}
}
