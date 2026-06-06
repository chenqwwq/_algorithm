package _96

import "testing"

func Test_numTrees(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "first",
			args: args{
				3,
			},
			want: 5,
		},
		{
			name: "second",
			args: args{
				1,
			},
			want: 1,
		},
		{
			name: "third",
			args: args{
				2,
			},
			want: 2,
		},
		{
			name: "simple",
			args: args{
				4,
			},
			want: 14,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numTrees(tt.args.n); got != tt.want {
				t.Errorf("numTrees() = %v, want %v", got, tt.want)
			}
		})
	}
}
