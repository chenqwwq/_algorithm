package _20200905

import "testing"

/**
 * @author chen
 * @date: 2020/9/5 下午3:29
 * @description:
 *
 */

func Test_getPermutation(t *testing.T) {
	type args struct {
		n int
		k int
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		/**
		示例 1:

		输入: n = 3, k = 3
		输出: "213"
		示例 2:

		输入: n = 4, k = 9
		输出: "2314"
		*/
		{
			name: "1",
			args: args{3, 3},
			want: "213",
		},
		{
			name: "2",
			args: args{4, 9},
			want: "2314",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := getPermutation(tt.args.n, tt.args.k); got != tt.want {
				t.Errorf("getPermutation() = %v, want %v", got, tt.want)
			}
		})
	}
}
