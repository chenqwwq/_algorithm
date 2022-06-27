package _3

import "testing"

/**
 * @author chen
 * @date: 2020/8/8 下午11:13
 */

func Test_minInsertions(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "case1",
			args: args{")))()))))))((()))())))()))))()))()())((()()))()(())()())()()))))))()()((()))("},
			want: 28,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minInsertions(tt.args.s); got != tt.want {
				t.Errorf("minInsertions() = %v, want %v", got, tt.want)
			}
		})
	}
}
