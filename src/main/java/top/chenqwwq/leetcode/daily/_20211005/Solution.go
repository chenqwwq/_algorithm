package _20211005

/**
 * @author chen
 * @date: 2021/10/5 9:57 上午
 * @description:
 *
 */

type Iterator struct {
}

func (this *Iterator) hasNext() bool {
	return false
}

func (this *Iterator) next() int {
	return 1
}

// PeekingIterator 通过一个简单的 Iterator 构造一个带 peek 函数的
// peek 函数不会移动指针，next 会移动指针
// 所以当前的数值和是否有下一个需要额外存储
type PeekingIterator struct {
	iterator *Iterator
	_hasNext bool
	_next int
}

func Constructor(iter *Iterator) *PeekingIterator {

	return &PeekingIterator{
		iterator: iter,
		_hasNext: iter.hasNext(),
		_next: iter.next(),
	}

}

func (this *PeekingIterator) hasNext() bool {
	return this._hasNext
}

func (this *PeekingIterator) next() int {
	ans := this._next
	this._hasNext = this.iterator.hasNext()
	if this._hasNext{
		this._next = this.iterator.next()
	}
	return ans
}

func (this *PeekingIterator) peek() int {
	return this._next
}
