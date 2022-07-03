package _10_10

const MAX = 50002

type StreamRank struct {
	tree []int
}

func lowbit(i int) int {
	return i & -i
}

func (sr *StreamRank) add(pos int) {
	for pos < MAX {
		sr.tree[pos]++
		pos += lowbit(pos)
	}
}

func (sr *StreamRank) sum(pos int) int {
	ans := 0
	for pos >= 1 {
		ans += sr.tree[pos]
		pos -= lowbit(pos)
	}
	return ans
}

func Constructor() StreamRank {
	data := make([]int, MAX)
	return StreamRank{tree: data}
}

func (this *StreamRank) Track(x int) {
	this.add(x + 1)
}

func (this *StreamRank) GetRankOfNumber(x int) int {
	return this.sum(x + 1)
}
