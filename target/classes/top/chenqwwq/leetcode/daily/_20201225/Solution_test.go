package _20201225

import "testing"

/**
  @user: chenqwwq
  @date: 2020/12/25
*/

func Test_findContentChildren(t *testing.T) {
	type args struct {
		g []int
		s []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "2",
			args:
			args{[]int{1, 2, 3},
				[]int{3},
			},
			want: -1,
		},
		{
			name: "1",
			args:
			args{[]int{1, 2, 3},
				[]int{1, 1},
			},
			want: 1,
		},
		{
			name: "2",
			args:
			args{[]int{1, 2},
				[]int{1, 2, 3},
			},
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := findContentChildren(tt.args.g, tt.args.s); got != tt.want {
				t.Errorf("findContentChildren() = %v, want %v", got, tt.want)
			}
		})
	}
}
