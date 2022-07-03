package _2

import "testing"

/**
 * @author chen
 * @date: 2020/9/13 上午11:20
 * @description:
 *
 */

func Test_unhappyFriends(t *testing.T) {
	type args struct {
		n           int
		preferences [][]int
		pairs       [][]int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			// n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
			name: "1",
			args: args{4, [][]int{{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}}, [][]int{{1, 3}, {0, 2}}},
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := unhappyFriends(tt.args.n, tt.args.preferences, tt.args.pairs); got != tt.want {
				t.Errorf("unhappyFriends() = %v, want %v", got, tt.want)
			}
		})
	}
}
