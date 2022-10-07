package _2

import (
	"testing"
)

/**
 * @author chen
 * @date: 2020/8/8 下午10:56
 */

func Test_canConvertString(t *testing.T) {
	type args struct {
		s string
		t string
		k int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "case1",
			args: args{
				"atmtxzjkz",
				"tvbtjhvjd",
				35},

			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := canConvertString(tt.args.s, tt.args.t, tt.args.k); got != tt.want {
				t.Errorf("canConvertString() = %v, want %v", got, tt.want)
			}
		})
	}
}
