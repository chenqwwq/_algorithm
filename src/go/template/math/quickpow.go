package quickpow

/**
  @user: chenqwwq
  @date: 2021/8/20
*/

// pow 递归形式
func pow(base, n int64) int64 {
	if n == 0 {
		return 1
	}
	ans := pow(base, n>>1)
	if n&1 == 0 {
		return ans * ans
	}
	return ans * ans * base
}

// pow2 非递归形式的
func pow2(base, n int64) int64 {
	if n == 0 {
		return 1
	}
	ans := int64(1)
	for n > 0 {
		if n&1 == 1 {
			ans *= base
		}
		base *= base
		n >>= 1
	}
	return ans
}
