package _20210226

import (
	"reflect"
	"testing"
)

/**
  @user: chenqwwq
  @date: 2021/2/26
*/

func Test_findNumOfValidWords(t *testing.T) {
	type args struct {
		words   []string
		puzzles []string
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		/**
		示例：
		输入：
		words = ["aaaa","asas","able","ability","actt","actor","access"],
		puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
		输出：[1,1,3,2,4,0]
		*/
		{
			name: "case1",
			args: args{
				words:   []string{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
				puzzles: []string{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"},
			},
			want: []int{1, 1, 3, 2, 4, 0},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := findNumOfValidWords(tt.args.words, tt.args.puzzles); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("findNumOfValidWords() = %v, want %v", got, tt.want)
			}
		})
	}
}
