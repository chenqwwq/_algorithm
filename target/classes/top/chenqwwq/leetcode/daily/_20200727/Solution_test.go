package _20200727

import "testing"

/**
  @user: chenqwwq
  @date: 2020/7/27
*/

func Test_twoPoint(t *testing.T) {
	type args struct {
		s string
		t string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"case1",
			args{"abc", "ahbgdc"},
			true},
		{"case2",
			args{"axc", "ahbgdc"},
			false},
		{"case3",
			args{"", ""},
			true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := twoPoint(tt.args.s, tt.args.t); got != tt.want {
				t.Errorf("twoPoint() = %v, want %v", got, tt.want)
			}
		})
	}
}
