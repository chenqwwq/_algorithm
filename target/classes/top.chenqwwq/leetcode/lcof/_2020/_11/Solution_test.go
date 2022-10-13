package _20200722

import "testing"

/**
 * @author chen
 * @date: 2020/7/22 上午6:43
 */

/**
示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0
*/

func Test_minArray(t *testing.T) {
	type args struct {
		numbers []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "first",
			args: args{
				numbers: []int{3, 4, 5, 1, 2},
			},
			want: 1,
		},
		{
			name: "second",
			args: args{
				numbers: []int{2, 2, 2, 0, 1},
			},
			want: 0,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minArray(tt.args.numbers); got != tt.want {
				t.Errorf("minArray() = %v, want %v", got, tt.want)
			}
		})
	}
}
