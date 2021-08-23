package _20200730

import "testing"

/**
  @user: chenqwwq
  @date: 2020/7/30
*/

func Test_integerBreak(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{1}, 1},
		{"case1", args{2}, 1},
		{"case1", args{10}, 36},
		{"case1", args{30}, 59049},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := integerBreak(tt.args.n); got != tt.want {
				t.Errorf("integerBreak() = %v, want %v", got, tt.want)
			}
		})
	}
}
