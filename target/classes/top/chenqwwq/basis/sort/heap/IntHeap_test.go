package heap

import (
	"reflect"
	"testing"
)

/**
 * @author chen
 * @date: 2021/1/3 下午10:57
 * @description:
 *
 */

func TestIntHeap_InitFromCollection(t *testing.T) {
	type fields struct {
		data []int
		size int
	}
	type args struct {
		elements []int
	}
	tests := []struct {
		name   string
		fields fields
		args   args
	}{
		{
			name: "1",
			fields: fields{
				data: []int{9, 6, 8, 5, 4},
				size: 5,
			},
			args: args{[]int{4, 6, 8, 5, 9}},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			i := &IntHeap{
				data: tt.fields.data,
				size: tt.fields.size,
			}
			if i.size != tt.
		})
	}
}

func TestIntHeap_Poll(t *testing.T) {
	type fields struct {
		data []int
		size int
	}
	tests := []struct {
		name   string
		fields fields
		want   int
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			i := &IntHeap{
				data: tt.fields.data,
				size: tt.fields.size,
			}
			if got := i.Poll(); got != tt.want {
				t.Errorf("Poll() = %v, want %v", got, tt.want)
			}
		})
	}
}

func TestIntHeap_Push(t *testing.T) {
	type fields struct {
		data []int
		size int
	}
	type args struct {
		item int
	}
	tests := []struct {
		name   string
		fields fields
		args   args
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			i := &IntHeap{
				data: tt.fields.data,
				size: tt.fields.size,
			}
		})
	}
}

func TestIntHeap_heapify(t *testing.T) {
	type fields struct {
		data []int
		size int
	}
	tests := []struct {
		name   string
		fields fields
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			i := &IntHeap{
				data: tt.fields.data,
				size: tt.fields.size,
			}
		})
	}
}

func TestIntHeap_siftDown(t *testing.T) {
	type fields struct {
		data []int
		size int
	}
	type args struct {
		idx     int
		element int
	}
	tests := []struct {
		name   string
		fields fields
		args   args
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			i := &IntHeap{
				data: tt.fields.data,
				size: tt.fields.size,
			}
		})
	}
}

func TestIntHeap_siftUp(t *testing.T) {
	type fields struct {
		data []int
		size int
	}
	type args struct {
		idx     int
		element int
	}
	tests := []struct {
		name   string
		fields fields
		args   args
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			i := &IntHeap{
				data: tt.fields.data,
				size: tt.fields.size,
			}
		})
	}
}

func TestNewIntHeap(t *testing.T) {
	type args struct {
		capacity int
		topBig   bool
	}
	tests := []struct {
		name string
		args args
		want *IntHeap
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := NewIntHeap(tt.args.capacity, tt.args.topBig); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("NewIntHeap() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_max(t *testing.T) {
	type args struct {
		a int
		b int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := max(tt.args.a, tt.args.b); got != tt.want {
				t.Errorf("max() = %v, want %v", got, tt.want)
			}
		})
	}
}
