package _20200819

import "testing"

/**
  @user: chenqwwq
  @date: 2020/8/21
*/

func Test_countSubstrings(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例 1：

		输入："abc"
		输出：3
		解释：三个回文子串: "a", "b", "c"
		示例 2：

		输入："aaa"
		输出：6
		解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
		提示：

		输入的字符串长度不会超过 1000 。
		 */
		{
			name: "1",
			args: args{"abc"},
			want: 3,
		},
		{
			name: "2",
			args: args{"aaa"},
			want: 6,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := countSubstrings(tt.args.s); got != tt.want {
				t.Errorf("countSubstrings() = %v, want %v", got, tt.want)
			}
		})
	}
}
