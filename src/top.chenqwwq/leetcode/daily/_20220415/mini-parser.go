package main

import (
	"fmt"
	"strconv"
	"unicode"
)

/**
 * @author chen
 * @date: 2022/4/15
 * @description:
 **/
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
type NestedInteger struct {
}

// Return true if this NestedInteger holds a single integer, rather than a nested list.
func (n NestedInteger) IsInteger() bool {
	return false
}

// Return the single integer that this NestedInteger holds, if it holds a single integer
// The result is undefined if this NestedInteger holds a nested list
// So before calling this method, you should have a check
func (n NestedInteger) GetInteger() int {
	return 1
}

// Set this NestedInteger to hold a single integer.
func (n *NestedInteger) SetInteger(value int) {}

// Set this NestedInteger to hold a nested list and adds a nested integer to it.
func (n *NestedInteger) Add(elem NestedInteger) {}

// Return the nested list that this NestedInteger holds, if it holds a nested list
// The list length is zero if this NestedInteger holds a single integer
// You can access NestedInteger's List element directly if you want to modify it
func (n NestedInteger) GetList() []*NestedInteger {
	return nil
}

func deserialize(s string) *NestedInteger {
	if s[0] != '[' {
		ans := NestedInteger{}
		num, _ := strconv.Atoi(s)
		ans.SetInteger(num)
		return &ans
	}
	var dfs func(i int) *NestedInteger
	dfs = func(i int) *NestedInteger {
		cur := 0
		negative := false
		ans := NestedInteger{}
		for ; i < len(s); i++ {
			if unicode.IsDigit(rune(s[i])) {
				cur = cur*10 + int(s[i]-'0')
			} else if s[i] == '[' {
				if negative {
					cur *= -1
				}
				ans.Add(*dfs(i + 1))
				ans.SetInteger(cur)
				return &ans
			} else if s[i] == '-' {
				negative = true
			} else if s[i] != ',' {
				if negative {
					cur *= -1
				}
				ans.SetInteger(cur)
				return &ans
			}
		}
		return nil
	}
	return dfs(1)
}

func main() {
	integer := deserialize("[123,[456,[789]]]")
	fmt.Println(integer)
}
