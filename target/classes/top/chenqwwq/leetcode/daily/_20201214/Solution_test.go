package _20201214

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2020/12/14
*/

func Test_groupAnagrams(t *testing.T) {
	type args struct {
		strs []string
	}
	tests := []struct {
		name string
		args args
		want [][]string
	}{
		{
			name: "1",
			args: args{[]string{"bdddddddddd", "bbbbbbbbbbc"}},
			want: [][]string{{"bbbbbbbbbbc"},{"bdddddddddd"}},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := groupAnagrams(tt.args.strs); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("groupAnagrams() = %v, want %v", got, tt.want)
			}
		})
	}
}
