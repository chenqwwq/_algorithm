package _3

import "testing"

/**
 * @author chen
 * @date: 2020/9/13 上午1:48
 * @description:
 *
 */

func Test_minimumOperations(t *testing.T) {
	type args struct {
		leaves string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		//{
		//	name: "1",
		//	args: args{"rrryyyrryyyrr"},
		//	want: 2,
		//},
		{
			name: "2",
			args: args{"yry"},
			want: 3,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minimumOperations(tt.args.leaves); got != tt.want {
				t.Errorf("minimumOperations() = %v, want %v", got, tt.want)
			}
		})
	}
}
