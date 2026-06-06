package _20200904

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/9/4
*/

func Test_binaryTreePaths(t *testing.T) {
	type args struct {
		root *TreeNode
	}
	tests := []struct {
		name string
		args args
		want []string
	}{
		/**
		示例:

		输入:

		   1
		 /   \
		2     3
		 \
		  5

		输出: ["1->2->5", "1->3"]
		解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
		*/
		{
			name: "1",
			args: args{
				&TreeNode{
					1,
					&TreeNode{
						2,
						nil,
						&TreeNode{
							5, nil, nil,
						},
					},
					&TreeNode{3, nil, nil},
				},
			},
			want: []string{"1->2->5", "1->3"},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := binaryTreePaths(tt.args.root); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("binaryTreePaths() = %v, want %v", got, tt.want)
			}
		})
	}
}
