package _20201207

import "testing"

/**
 * @author chen
 * @date: 2020/12/7 下午9:25
 * @description:
 *
 */

func Test_matrixScore(t *testing.T) {
	type args struct {
		A [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
		输出：39
		解释：
		转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
		0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
		*/
		{
			name: "1",
			args: args{
				[][]int{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}},
			},
			want: 39,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := matrixScore(tt.args.A); got != tt.want {
				t.Errorf("matrixScore() = %v, want %v", got, tt.want)
			}
		})
	}
}
