package _2

import "testing"

/**
 * @author chen
 * @date: 2020/9/6 上午11:14
 * @description:
 *
 */

func Test_numTriplets(t *testing.T) {
	type args struct {
		nums1 []int
		nums2 []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "1",
			args: args{
				[]int{7, 4},
				[]int{5, 2, 8, 9},
			},
			want: 1,
		},
		{
			name: "1",
			args: args{
				[]int{1, 1},
				[]int{1, 1, 1},
			},
			want: 9,
		},
		{
			name: "1",
			args: args{
				[]int{4, 7, 9, 11, 23},
				[]int{3, 5, 1024, 12, 18},
			},
			want: 0,
		},
		{
			name: "1",
			args: args{
				[]int{7, 7, 8, 3},
				[]int{1, 2, 9, 7},
			},
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := numTriplets(tt.args.nums1, tt.args.nums2); got != tt.want {
				t.Errorf("numTriplets() = %v, want %v", got, tt.want)
			}
		})
	}
}
