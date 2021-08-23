package _20200731

import "testing"

/**
  @user: chenqwwq
  @date: 2020/7/31
*/

func Test_findMagicIndex(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例1:
		 输入：nums = [0, 2, 3, 4, 5]
		 输出：0
		 说明: 0下标的元素为0

		示例2:
		 输入：nums = [1, 1, 1]
		 输出：1
		*/
		{"case", args{[]int{0, 0, 2}}, 0},
		{"case1", args{[]int{0, 2, 3, 4, 5}}, 0},
		{"case2", args{[]int{1, 1, 1}}, 1},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := findMagicIndex(tt.args.nums); got != tt.want {
				t.Errorf("findMagicIndex() = %v, want %v", got, tt.want)
			}
		})
	}
}
