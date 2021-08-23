package _20200920

import (
	"reflect"
	"testing"
)

/**
 * @author chen
 * @date: 2020/9/20 下午6:15
 * @description:
 *
 */

func Test_subsets(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want [][]int
	}{
		{
			name: "1",
			args: args{[]int{1, 2, 3}},
			want: [][]int{
				{1},
				{2},
				{3},
				{1, 2, 3},
				{1, 2},
				{1, 3},
				{2, 3},
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := subsets(tt.args.nums); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("subsets() = %v, want %v", got, tt.want)
			}
		})
	}
}
