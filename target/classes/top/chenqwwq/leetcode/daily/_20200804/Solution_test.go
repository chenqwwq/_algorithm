package _20200804

import "testing"

/**
  @user: chenqwwq
  @date: 2020/8/5
*/

func Test_canFinish(t *testing.T) {
	type args struct {
		numCourses    int
		prerequisites [][]int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"case2", args{3, [][]int{{1, 0}, {2, 1}}}, true},
		{"case1", args{2, [][]int{{1, 0}}}, true},
		{"case2", args{2, [][]int{{1, 0}, {0, 1}}}, false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := canFinish(tt.args.numCourses, tt.args.prerequisites); got != tt.want {
				t.Errorf("canFinish() = %v, want %v", got, tt.want)
			}
		})
	}
}
