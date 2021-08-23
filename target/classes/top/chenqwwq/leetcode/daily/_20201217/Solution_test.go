package _20201217

import "testing"

/**
  @user: chenqwwq
  @date: 2020/12/17
*/

func Test_maxProfit(t *testing.T) {
	type args struct {
		prices []int
		fee    int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
		输出: 8
		*/
		{
			name: "1",
			args: args{[]int{1, 3, 2, 8, 4, 9}, 2},
			want: 8,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxProfit(tt.args.prices, tt.args.fee); got != tt.want {
				t.Errorf("maxProfit() = %v, want %v", got, tt.want)
			}
		})
	}
}
