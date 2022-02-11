package main

type Stack struct {
	slice1 []int
}

func (this *Stack) Push(x int) {
	this.slice1 = append(this.slice1, x)
}

func (this *Stack) Pop() int {
	if len(this.slice1) == 0 {
		return -1
	}
	v := this.slice1[len(this.slice1)-1]
	this.slice1 = this.slice1[:len(this.slice1)-1]
	return v
}

func (this *Stack) Top() int {
	if len(this.slice1) == 0 {
		return -1
	}
	return this.slice1[len(this.slice1)-1]
}

func (this *Stack) Len() int {
	return len(this.slice1)
}

type MinStack struct {
	Stack    Stack
	StackMin Stack
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{}
}

func (this *MinStack) Push(x int) {
	this.Stack.Push(x)

	if this.StackMin.Len() == 0 {
		this.StackMin.Push(x)
	} else if x <= this.StackMin.Top() {
		this.StackMin.Push(x)
	}
}

func (this *MinStack) Pop() {

	v := this.Stack.Pop()

	if this.StackMin.Top() == v {
		this.StackMin.Pop()
	}

}

func (this *MinStack) Top() int {
	return this.Stack.Top()
}

func (this *MinStack) Min() int {
	return this.StackMin.Top()
}
