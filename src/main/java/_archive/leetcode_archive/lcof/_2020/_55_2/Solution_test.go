package _55_2

import (
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/7/23
*/

func Test_isBalanced(t *testing.T) {
	type args struct {
		root *TreeNode
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "testCase1",
			args: args{
				root: &TreeNode{3, &TreeNode{9, nil, nil}, &TreeNode{20, &TreeNode{15, nil, nil}, &TreeNode{7, nil, nil}}},
			},
			want: true,
		},
		{
			name: "testCase2",
			args: args{
				root: &TreeNode{
					1,
					&TreeNode{2,
						&TreeNode{3,
							&TreeNode{4, nil, nil},
							nil},
						nil},
					&TreeNode{2, nil,
						&TreeNode{3,
							nil,
							&TreeNode{4, nil, nil}},
					},
				},
			},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isBalanced(tt.args.root); got != tt.want {
				t.Errorf("isBalanced() = %v, want %v", got, tt.want)
			}
		})
	}
}
