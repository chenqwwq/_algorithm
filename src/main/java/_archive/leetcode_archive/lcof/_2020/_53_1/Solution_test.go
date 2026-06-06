package _53_1

import "testing"

/**
  @user: chenqwwq
  @date: 2020/7/24
*/

func Test_search(t *testing.T) {
	type args struct {
		nums   []int
		target int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例 1:

		输入: nums = [5,7,7,8,8,10], target = 8
		输出: 2
		示例 2:

		输入: nums = [5,7,7,8,8,10], target = 6
		输出: 0
		
		来源：力扣（LeetCode）
		链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
		*/
		{
			name: "case3",
			args: args{
				nums:   []int{1},
				target: 1,
			},
			want: 1,
		},
		{
			name: "case1",
			args: args{
				nums:   []int{5, 7, 7, 8, 8, 10},
				target: 8,
			},
			want: 2,
		},
		{
			name: "case2",
			args: args{
				nums:   []int{5, 7, 7, 8, 8, 10},
				target: 6,
			},
			want: 0,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := search(tt.args.nums, tt.args.target); got != tt.want {
				t.Errorf("search() = %v, want %v", got, tt.want)
			}
		})
	}
}
