func isValid(s string) bool {
	arr := make([]rune, 0)

	m := map[rune]rune{
		']': '[',
		'}': '{',
		')': '(',
	}

	for _, r := range s {
		if r == '(' || r == '[' || r == '{' {
			arr = append(arr, r)
			continue
		}
		if len(arr) > 0 && m[r] == arr[len(arr)-1] {
			arr = arr[:len(arr)-1]
			continue
		}
		return false
	}
	return len(arr) == 0
}
