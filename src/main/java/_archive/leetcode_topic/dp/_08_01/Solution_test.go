package _08_01

import "testing"

/**
  @user: chenqwwq
  @date: 2020/8/11
*/

func Test_waysToStep(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		/**
		示例1:
		 输入：n = 3
		 输出：4
		 说明: 有四种走法

		示例2:
		 输入：n = 5
		 输出：13
		提示:

		n范围在[1, 1000000]之间
		*/
		//{
		//	name: "case1",
		//	args: args{
		//		n: 3,
		//	},
		//	want: 4,
		//},
		{
			name: "case1",
			args: args{
				n: 5,
			},
			want: 13,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := waysToStep(tt.args.n); got != tt.want {
				t.Errorf("waysToStep() = %v, want %v", got, tt.want)
			}
		})
	}
}
