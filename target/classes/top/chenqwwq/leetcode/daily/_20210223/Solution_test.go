package _20210223

import (
	"testing"
)

/**
 * @author chen
 * @date: 2021/2/23 下午9:36
 * @description:
 *
 */

func Test_maxSatisfied(t *testing.T) {
	type args struct {
		customers []int
		grumpy    []int
		X         int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例：
		输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
		输出：16
		*/
		{
			name: "1",
			args: args{
				customers: []int{1, 0, 1, 2, 1, 1, 7, 5},
				grumpy:    []int{0, 1, 0, 1, 0, 1, 0, 1},
				X:         3,
			},
			want: 16,
		},
		{
			name: "2",
			args: args{
				customers: []int{3},
				grumpy:    []int{1},
				X:         1,
			},
			want: 3,
		},
		{
			name: "3",
			args: args{
				customers: []int{1},
				grumpy:    []int{0},
				X:         1,
			},
			want: 1,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxSatisfied(tt.args.customers, tt.args.grumpy, tt.args.X); got != tt.want {
				t.Errorf("maxSatisfied() = %v, want %v", got, tt.want)
			}
		})
	}
}
