package _3

import (
	"testing"
)

/**
 * @author chen
 * @date: 2020/9/14 上午11:43
 * @description:
 *
 */

func Test_minCostConnectPoints(t *testing.T) {
	type args struct {
		points [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		//{
		//	name: "1",
		//	args: args{[][]int{{3, 12}, {-2, 5}, {-4, 1}}},
		//	want: 18,
		//},
		{
			name: "2",
			args: args{[][]int{{-1000000, -1000000}, {1000000, 1000000}}},
			want: 1,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minCostConnectPoints(tt.args.points); got != tt.want {
				t.Errorf("minCostConnectPoints() = %v, want %v", got, tt.want)
			}
		})
	}
}
