package _20201222

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/12/23
*/

func Test_zigzagLevelOrder(t *testing.T) {
	type args struct {
		root *TreeNode
	}
	tests := []struct {
		name string
		args args
		want [][]int
	}{
		{
			name: "1",
			args: args{&TreeNode{3, &TreeNode{9, nil, nil}, &TreeNode{20, &TreeNode{15, nil, nil}, &TreeNode{7, nil, nil}}}},
			want: [][]int{{3}, {20, 9}, {15, 7}},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := zigzagLevelOrder(tt.args.root); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("zigzagLevelOrder() = %v, want %v", got, tt.want)
			}
		})
	}
}
