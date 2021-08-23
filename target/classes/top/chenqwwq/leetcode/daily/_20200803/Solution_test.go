package _20200803

import "testing"

/**
  @user: chenqwwq
  @date: 2020/8/3
*/

func Test_addStrings(t *testing.T) {
	type args struct {
		num1 string
		num2 string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "case1",
			args: args{
				num1: "123",
				num2: "123",
			},
			want: "246",
		},
		{
			name: "case5",
			args: args{
				num1: "555",
				num2: "666",
			},
			want: "1221",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := addStrings(tt.args.num1, tt.args.num2); got != tt.want {
				t.Errorf("addStrings() = %v, want %v", got, tt.want)
			}
		})
	}
}
