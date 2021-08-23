package BinaryIndexedTree

/**
 * @author chen
 * @date: 2021/1/14 下午10:52
 * @description:
 *
 */

// 树状数组
// 相当于前缀和的优化，前缀和能将求区间和的复杂度降低到O(1)，但是对于修改复杂度确实O(n)的
// #link https://www.cnblogs.com/xenny/p/9739600.html

type Bit struct {
	data []int
}

// NewBit 从一个原始数组初始化为树状数组
func NewBit(data []int) *Bit {
	n := len(data)
	if n == 0 {
		return &Bit{[]int{}}
	}
	//bit := Bit{make([]int, n)}
	//
	//// 以单点更新的形式初始化
	//for i := 0; i < n; i++ {
	//	bit.Update(i, data[i])
	//}
	//
	//return &bit
	buf := make([]int, n)
	total, sum := 0, 0
	for i := 0; i < n; i++ {
		sum += data[i]
		// 遇到2次幂为前缀和
		if lowbit(i+1) == i+1 {
			total += sum
			buf[i] = total
			sum = 0
			continue
		}
		buf[i] = sum
		// 遇到偶数清空当前和
		if (i+1)&1 == 0 {
			total += sum
			sum = 0
		}
	}
	return &Bit{buf}
}

// Update 单点更新 ,需要将后续涉及的节点一起更新
func (target *Bit) Update(idx, num int) {
	var n = len(target.data)
	for idx < n {
		target.data[idx] += num
		// 如果更新3,idx从3 -> 4 -> 8
		idx += lowbit(idx)
	}
}

// GetRange 范围查询
func (target *Bit) GetRange(l, r int) int {
	return target.GetSum(r) - target.GetSum(l)
}

// GetSum 获取从0~i的和
func (target *Bit) GetSum(i int) int {
	ans := 0
	for i > 0 {
		ans += target.data[i]
		i -= lowbit(i)
	}
	return ans
}

func (target *Bit) Add(i int){
  
}


// lowbit 获得最后一位1
// 例如12 => 1100，-12 => 0100 ,12 & -12 => 0100
func lowbit(i int) int {
	return i & -i
}
