package _7

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/7/22
*/

func Test_buildTree(t *testing.T) {
	type args struct {
		preorder []int
		inorder  []int
	}
	tests := []struct {
		name string
		args args
		want *TreeNode
	}{
		{
			name: "simple0",
			args: args{[]int{1, 2}, []int{1, 1}},
			want: &TreeNode{1, nil, &TreeNode{2, nil, nil}},
		},
		/**
		前序遍历 preorder = [3,9,20,15,7]
		中序遍历 inorder = [9,3,15,20,7]
		返回如下的二叉树：

		    3
		   / \
		  9  20
		    /  \
		   15   7
		*/
		{
			name: "simple",
			args: args{[]int{3, 9, 20, 15, 7}, []int{9, 3, 15, 20, 7}},
			want: &TreeNode{3, &TreeNode{9, nil, nil}, &TreeNode{20, &TreeNode{15, nil, nil}, &TreeNode{7, nil, nil}}},
		},
		{
			name: "simple1",
			args: args{[]int{1, 2}, []int{2, 1}},
			want: &TreeNode{1, &TreeNode{2, nil, nil}, nil},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := buildTree(tt.args.preorder, tt.args.inorder); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("buildTree() = %v, want %v", got, tt.want)
			}
		})
	}
}
