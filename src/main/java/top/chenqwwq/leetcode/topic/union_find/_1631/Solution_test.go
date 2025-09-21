package _1631

import (
	"testing"
)

/**
  @user: chenqwwq
  @date: 2021/1/29
*/

func Test_minimumEffortPath(t *testing.T) {
	type args struct {
		heights [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		//{
		//	name: "case1",
		//	args: args{[][]int{{1, 2, 2},
		//		{3, 8, 2},
		//		{5, 3, 5}}},
		//	want: 2,
		//},
		{
			name: "error1",
			args: args{[][]int{{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2}, {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}}},
			want: 5,
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minimumEffortPath(tt.args.heights); got != tt.want {
				t.Errorf("minimumEffortPath() = %v, want %v", got, tt.want)
			}
		})
	}
}
