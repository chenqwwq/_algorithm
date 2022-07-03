package _547

import "testing"

/**
  @user: chenqwwq
  @date: 2020/12/31
*/

func Test_findCircleNum(t *testing.T) {
	type args struct {
		M [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例 1：
		输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
		输出：2
		示例 2：
		输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
		输出：3
		*/
		{
			name: "1",
			args: args{[][]int{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}},
			want: 2,
		},
		{
			name: "2",
			args: args{[][]int{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}},
			want: 3,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := findCircleNum(tt.args.M); got != tt.want {
				t.Errorf("findCircleNum() = %v, want %v", got, tt.want)
			}
		})
	}
}
