package main

import (
	"fmt"
)

const BIT_SIZE int = 32

func getBit(n uint32, k uint32) uint32 {
	var bitSet uint32
	if n&(1<<k) != 0 {
		bitSet = 1
	}
	return bitSet
}

func bitWiseOR(arr []uint32) uint32 {
	var result uint32
	n := len(arr)
	bitFreq := make([]uint32, BIT_SIZE)
	for i := 0; i < n; i++ {
		for k := BIT_SIZE - 1; k >= 0; k-- {
			bitFreq[k] += getBit(arr[i], uint32(k))
		}
	}
	for j := 0; j < BIT_SIZE; j++ {
		for bitFreq[j] > 0 {
			result += ((1 << uint32(j)) * (1 << (uint32(n) - bitFreq[j])))
			bitFreq[j]--
		}
	}
	return result
}
func main() {
	arr := []uint32{1, 2, 3, 4}
	fmt.Println("print array:", arr)
	fmt.Println("bitWiseOr:", bitWiseOR(arr))

}
