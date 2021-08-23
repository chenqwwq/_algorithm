package _20201221

import "testing"

/**
  @user: chenqwwq
  @date: 2020/12/23
*/

func Test_minCostClimbingStairs(t *testing.T) {
	type args struct {
		cost []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "1",
			args: args{[]int{10,15,20}},
			want: 15,
		},
		{
			name: "2",
			args: args{[]int{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}},
			want: 6,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minCostClimbingStairs(tt.args.cost); got != tt.want {
				t.Errorf("minCostClimbingStairs() = %v, want %v", got, tt.want)
			}
		})
	}
}
