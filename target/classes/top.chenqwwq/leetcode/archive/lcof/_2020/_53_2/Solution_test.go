package _53_2

import "testing"

/**
  @user: chenqwwq
  @date: 2020/7/24
*/

func Test_missingNumber(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例 1:

		输入: [0,1,3]
		输出: 2
		示例 2:

		输入: [0,1,2,3,4,5,6,7,9]
		输出: 8
		*/
		{
			name: "case1",
			args: args{
				nums: []int{0, 1, 3},
			},
			want: 2,
		},
		{
			name: "case2",
			args: args{
				nums: []int{0, 1, 2, 3, 4, 5, 6, 7, 9},
			},
			want: 8,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := missingNumber(tt.args.nums); got != tt.want {
				t.Errorf("missingNumber() = %v, want %v", got, tt.want)
			}
		})
	}
}
