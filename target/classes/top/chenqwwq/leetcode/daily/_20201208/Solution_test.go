package _20201208

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/12/9
*/

func Test_splitIntoFibonacci(t *testing.T) {
	type args struct {
		S string
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		/**
		示例 1：

		输入："123456579"
		输出：[123,456,579]
		示例 2：

		输入: "11235813"
		输出: [1,1,2,3,5,8,13]
		示例 3：

		输入: "112358130"
		输出: []
		解释: 这项任务无法完成。
		示例 4：

		输入："0123"
		输出：[]
		解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
		示例 5：

		输入: "1101111"
		输出: [110, 1, 111]
		解释: 输出 [11,0,11,11] 也同样被接受。
		*/
		{
			name: "1",
			args: args{
				"123456579",
			},
			want: []int{123, 456, 579},
		},
		{
			name: "2",
			args: args{
				"11235813",
			},
			want: []int{1, 1, 2, 3, 5, 8, 13},
		},
		{
			name: "3",
			args: args{
				"112358130",
			},
			want: []int{},
		},
		{
			name: "4",
			args: args{
				"0123",
			},
			want: []int{},
		},
		{
			name: "5",
			args: args{
				"1101111",
			},
			want: []int{11, 0, 1, 111},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := splitIntoFibonacci(tt.args.S); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("splitIntoFibonacci() = %v, want %v", got, tt.want)
			}
		})
	}
}
