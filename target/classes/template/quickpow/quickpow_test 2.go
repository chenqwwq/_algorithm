package quickpow

import (
	"math"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2021/8/20
*/

func Test_pow(t *testing.T) {
	type args struct {
		b int64
		n int64
	}
	tests := []struct {
		name string
		args args
		want int64
	}{
		{
			name: "test1",
			args: args{
				2, 3,
			},
			want: 8,
		},
		{
			name: "test2",
			args: args{
				10,
				16,
			},
			want: int64(math.Pow(10, 16)),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := pow(tt.args.b, tt.args.n); got != tt.want {
				t.Errorf("pow() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_pow2(t *testing.T) {
	type args struct {
		base int64
		n    int64
	}
	tests := []struct {
		name string
		args args
		want int64
	}{
		{
			name: "test1",
			args: args{
				2, 3,
			},
			want: 8,
		},
		{
			name: "test2",
			args: args{
				10,
				16,
			},
			want: int64(math.Pow(10, 16)),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := pow2(tt.args.base, tt.args.n); got != tt.want {
				t.Errorf("pow2() = %v, want %v", got, tt.want)
			}
		})
	}
}
