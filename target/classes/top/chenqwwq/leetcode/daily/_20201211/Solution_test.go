package _20201211

import "testing"

/**
 * @author chen
 * @date: 2020/12/12 上午11:50
 * @description:
 *
 */

func Test_predictPartyVictory(t *testing.T) {
	type args struct {
		senate string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		/**
		输入："RD"
		输出："Radiant"
		解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
		示例 2：

		输入："RDD"
		输出："Dire"
		*/
		//{
		//	name: "1",
		//	args: args{"RD"},
		//	want: "Radiant",
		//},
		//{
		//	name: "2",
		//	args: args{"RDD"},
		//	want: "Dire",
		//},
		{
			name: "3",
			args: args{"DDRRR"},
			want: "Dire",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := predictPartyVictory(tt.args.senate); got != tt.want {
				t.Errorf("predictPartyVictory() = %v, want %v", got, tt.want)
			}
		})
	}
}
