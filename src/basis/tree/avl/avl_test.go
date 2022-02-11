package main

import (
	"reflect"
	"testing"
)

/**
 * @author chen
 * @date: 2021/10/6 下午10:33
 * @description:
 *
 */

func TestAVL_Add(t *testing.T) {
	type fields struct {
		root          *node
		balanceFactor int
	}
	type args struct {
		val int
	}
	tests := []struct {
		name   string
		fields fields
		args   args
		want   *node
	}{
		// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			avl := &AVL{
				root:          tt.fields.root,
				balanceFactor: tt.fields.balanceFactor,
			}
			if got := avl.Add(tt.args.val); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("Add() = %v, want %v", got, tt.want)
			}
		})
	}
}
