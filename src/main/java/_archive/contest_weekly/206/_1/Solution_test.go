package _1

import (
	"testing"
)

/**
 * @author chen
 * @date: 2020/9/13 上午10:36
 * @description:
 *
 */

func Test_numSpecial(t *testing.T) {
	type args struct {
		mat [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "1",
			args: args{[][]int{{1, 0, 0},
				{0, 1, 0},
				{1, 0, 0}}},
			want: 1,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numSpecial(tt.args.mat); got != tt.want {
				t.Errorf("numSpecial() = %v, want %v", got, tt.want)
			}
		})
	}
}
