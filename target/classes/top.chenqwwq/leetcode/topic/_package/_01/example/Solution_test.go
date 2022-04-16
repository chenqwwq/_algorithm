package example

import "testing"

/**
  @user: chenqwwq
  @date: 2020/9/21
*/

func Test__01backpack_basic(t *testing.T) {
	type args struct {
		n  int
		w  int
		wi []int
		vi []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "1",
			args: args{4, 8, []int{2, 3, 4, 5}, []int{3, 4, 5, 6}},
			want: 10,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := _01backpack_basic(tt.args.n, tt.args.w, tt.args.wi, tt.args.vi); got != tt.want {
				t.Errorf("_01backpack_basic() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test__01backpack_lessmemory(t *testing.T) {
	type args struct {
		n  int
		w  int
		wi []int
		vi []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "1",
			args: args{4, 8, []int{2, 3, 4, 5}, []int{3, 4, 5, 6}},
			want: 10,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := _01backpack_lessmemory(tt.args.n, tt.args.w, tt.args.wi, tt.args.vi); got != tt.want {
				t.Errorf("_01backpack_lessmemory() = %v, want %v", got, tt.want)
			}
		})
	}
}
