package _20201216

import "testing"

/**
  @user: chenqwwq
  @date: 2020/12/16
*/

func Test_wordPattern(t *testing.T) {
	type args struct {
		pattern string
		s       string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		/**
		示例1:

		输入: pattern = "abba", str = "dog cat cat dog"
		输出: true
		示例 2:

		输入:pattern = "abba", str = "dog cat cat fish"
		输出: false
		示例 3:

		输入: pattern = "aaaa", str = "dog cat cat dog"
		输出: false
		示例 4:

		输入: pattern = "abba", str = "dog dog dog dog"
		输出: false
		*/
		{
			name: "1",
			args: args{"abba", "dog cat cat dog"},
			want: true,
		},
		{
			name: "1",
			args: args{"abba", "dog cat cat fish"},
			want: false,
		},
		{
			name: "1",
			args: args{"aaaa", "dog cat cat dog"},
			want: false,
		},
		{
			name: "1",
			args: args{"abba", "dog dog dog dog"},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := wordPattern(tt.args.pattern, tt.args.s); got != tt.want {
				t.Errorf("wordPattern() = %v, want %v", got, tt.want)
			}
		})
	}
}
