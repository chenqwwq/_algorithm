package _20200824

import "testing"

/**
  @user: chenqwwq
  @date: 2020/8/24
*/

func Test_repeatedSubstringPattern(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		/**
		示例 1:

		输入: "abab"

		输出: True

		解释: 可由子字符串 "ab" 重复两次构成。
		示例 2:

		输入: "aba"

		输出: False
		示例 3:

		输入: "abcabcabcabc"

		输出: True

		解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
		 */
		{
			name: "1",
			args: args{"abab"},
			want: true,
		},
		{
			name: "2",
			args: args{"aba"},
			want: false,
		},
		{
			name: "1",
			args: args{"abcabcabcabc"},
			want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := repeatedSubstringPattern(tt.args.s); got != tt.want {
				t.Errorf("repeatedSubstringPattern() = %v, want %v", got, tt.want)
			}
		})
	}
}
