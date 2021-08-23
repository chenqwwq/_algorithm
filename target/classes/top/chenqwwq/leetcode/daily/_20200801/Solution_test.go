package _20200801

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/8/1
*/

func Test_smallestRange(t *testing.T) {
	type args struct {
		nums [][]int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		/**

		输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
		输出: [20,24]
		解释:
		列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
		列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
		列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
		注意:
		*/

		{
			name: "case1",
			args: args{
				[][]int{{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}},
			},

			want: []int{20, 24},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := smallestRange(tt.args.nums); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("smallestRange() = %v, want %v", got, tt.want)
			}
		})
	}
}
