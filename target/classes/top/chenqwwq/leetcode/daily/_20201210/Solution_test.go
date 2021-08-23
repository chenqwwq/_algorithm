package _20201210

import (
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/12/10
*/

func Test_lemonadeChange(t *testing.T) {
	type args struct {
		bills []int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "1",
			args: args{[]int{10, 10}},
			want: false,
		},
		{
			name: "2",
			args: args{[]int{5, 5, 10, 10, 20}},
			want: false,
		},
		{
			name: "3",
			args: args{[]int{5, 5, 10}},
			want: true,
		},
		{
			name: "4",
			args: args{[]int{5, 5, 10, 10, 20}},
			want: true,

	},
}
for _, tt := range tests {
t.Run(tt.name, func (t *testing.T) {
if got := lemonadeChange(tt.args.bills); got != tt.want {
t.Errorf("lemonadeChange() = %v, want %v", got, tt.want)
}
})
}
}
