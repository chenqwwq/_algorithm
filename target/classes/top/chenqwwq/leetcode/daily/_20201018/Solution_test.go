package _20201018

import (
	"reflect"
	"testing"
)

/**
 * @author chen
 * @date: 2020/10/18 下午3:30
 * @description:
 *
 */

func Test_removeNthFromEnd(t *testing.T) {
	type args struct {
		head *ListNode
		n    int
	}
	tests := []struct {
		name string
		args args
		want *ListNode
	}{
		{
			name: "2",
			args: args{
				head: &ListNode{1, &ListNode{2, nil}},
				n:    1,
			},
			want: &ListNode{1, nil},
		},
		{
			name: "1",
			args: args{
				head: &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}},
				n:    2,
			},
			want: &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{5, nil}}}},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := removeNthFromEnd(tt.args.head, tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("removeNthFromEnd() = %v, want %v", got, tt.want)
			}
		})
	}
}
