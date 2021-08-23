package _20201228

import "testing"

/**
  @user: chenqwwq
  @date: 2020/12/28
*/

func Test_maxProfit(t *testing.T) {
	type args struct {
		k      int
		prices []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例 1：
		输入：k = 2, prices = [2,4,1]
		输出：2
		解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
		示例 2：
		输入：k = 2, prices = [3,2,6,5,0,3]
		输出：7
		解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
		     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
		*/
		{
			name: "2",
			args: args{2, []int{3, 2, 6, 5, 0, 3}},
			want: 7,
		},
		{
			name: "1",
			args: args{2, []int{2, 4, 1}},
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxProfit(tt.args.k, tt.args.prices); got != tt.want {
				t.Errorf("maxProfit() = %v, want %v", got, tt.want)
			}
		})
	}
}
