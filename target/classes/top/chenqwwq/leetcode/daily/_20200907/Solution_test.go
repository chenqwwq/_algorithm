package _20200907

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/9/7
*/

func Test_topKFrequent(t *testing.T) {
	type args struct {
		nums []int
		k    int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		/**
		示例 1:

		输入: nums = [1,1,1,2,2,3], k = 2
		输出: [1,2]
		示例 2:

		//输入: nums = [1], k = 1
		//输出: [1]
		//*/
		{
			name: "2",
			args: args{[]int{-1, -1}, 1},
			want: []int{-1},
		},
		{
			name: "1",
			args: args{[]int{1, 1, 1, 2, 2, 3}, 2},
			want: []int{1, 2},
		},
		{
			name: "2",
			args: args{[]int{1}, 1},
			want: []int{1},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := topKFrequent(tt.args.nums, tt.args.k); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("topKFrequent() = %v, want %v", got, tt.want)
			}
		})
	}
}
