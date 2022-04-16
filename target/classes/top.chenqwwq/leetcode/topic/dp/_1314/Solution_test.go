package _1314

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/8/13
*/

func Test_matrixBlockSum(t *testing.T) {
	type args struct {
		mat [][]int
		K   int
	}
	tests := []struct {
		name string
		args args
		want [][]int
	}{
		/**
		示例 1：

		输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
		输出：[[12,21,16],[27,45,33],[24,39,28]]
		示例 2：

		输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
		输出：[[45,45,45],[45,45,45],[45,45,45]]
		*/
		{
			name: "case1",
			args: args{
				mat: [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
				K:   1,
			},
			want: [][]int{{12,21,16},{27,45,33},{24,39,28}},
		},
		{
			name: "case2",
			args: args{
				mat: [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
				K:   2,
			},
			want: [][]int{{45,45,45},{45,45,45},{45,45,45}},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := matrixBlockSum(tt.args.mat, tt.args.K); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("matrixBlockSum() = %v, want %v", got, tt.want)
			}
		})
	}
}
