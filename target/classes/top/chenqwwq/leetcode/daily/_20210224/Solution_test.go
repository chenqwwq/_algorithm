package _20210224

import (
	"reflect"
	"testing"
)

/**
 * @author chen
 * @date: 2021/2/24 下午10:20
 * @description:
 *
 */

func Test_flipAndInvertImage(t *testing.T) {
	type args struct {
		A [][]int
	}
	tests := []struct {
		name string
		args args
		want [][]int
	}{
		/**
		示例 1：
		输入：[[1,1,0],[1,0,1],[0,0,0]]
		输出：[[1,0,0],[0,1,0],[1,1,1]]
		解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
		     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]

		示例 2：
		输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
		输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
		解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
		     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
		*/
		{
			name: "case1",
			args: args{
				[][]int{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}},
			},
			want: [][]int{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}},
		},
		{
			name: "case2",
			args: args{
				[][]int{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}},
			},
			want: [][]int{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := flipAndInvertImage(tt.args.A); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("flipAndInvertImage() = %v, want %v", got, tt.want)
			}
		})
	}
}
