package _474

import "testing"

/**
  @user: chenqwwq
  @date: 2020/9/29
*/

func Test_findMaxForm(t *testing.T) {
	type args struct {
		strs []string
		m    int
		n    int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**

		示例 1:
		输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
		输出: 4
		解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。

		示例 2:
		输入: strs = ["10", "0", "1"], m = 1, n = 1
		输出: 2
		*/

		{
			name: "1",
			args: args{[]string{"10", "0001", "111001", "1", "0"}, 5, 3},
			want: 4,
		},
		{
			name: "2",
			args: args{[]string{"10", "0", "1"}, 1, 1},
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := findMaxForm(tt.args.strs, tt.args.m, tt.args.n); got != tt.want {
				t.Errorf("findMaxForm() = %v, want %v", got, tt.want)
			}
		})
	}
}
