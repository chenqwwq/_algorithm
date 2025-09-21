package _20220413

import "math/rand"

type RandomizedSet struct {
	nums []int
	set  map[int]int
}

func Constructor() RandomizedSet {
	return RandomizedSet{[]int{}, map[int]int{}}
}

func (r *RandomizedSet) Insert(val int) bool {
	if _, ex := r.set[val]; ex {
		return false
	}
	r.set[val] = len(r.nums)
	r.nums = append(r.nums, val)
	return true
}

func (r *RandomizedSet) Remove(val int) bool {
	id, ok := r.set[val]
	if !ok {
		return false
	}
	last := len(r.nums) - 1
	r.nums[id] = r.nums[last]
	r.set[r.nums[id]] = id
	r.nums = r.nums[:last]
	delete(r.set, val)
	return true
}

func (r *RandomizedSet) GetRandom() int {
	return r.nums[rand.Intn(len(r.nums))]
}
