package main

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/8/26
*/

func Test_letterCombinations(t *testing.T) {
	type args struct {
		digits string
	}
	tests := []struct {
		name string
		args args
		want []string
	}{
		{
			name: "1",
			args: args{
				"23",
			},
			want: []string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
		},
		{
			name: "2",
			args: args{
				"",
			},
			want: []string{},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := letterCombinations(tt.args.digits); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("letterCombinations() = %v, want %v", got, tt.want)
			}
		})
	}
}
