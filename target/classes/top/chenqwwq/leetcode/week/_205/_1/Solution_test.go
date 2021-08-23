package _1

import "testing"

/**
 * @author chen
 * @date: 2020/9/6 上午10:56
 * @description:
 *
 */

func Test_modifyString(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "1",
			args: args{"?zs"},
			want: "azs",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := modifyString(tt.args.s); got != tt.want {
				t.Errorf("modifyString() = %v, want %v", got, tt.want)
			}
		})
	}
}
