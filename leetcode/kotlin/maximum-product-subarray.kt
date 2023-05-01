import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var lastMax = nums[nums.lastIndex]
        var lastMin = nums[nums.lastIndex]
        var best = nums[nums.lastIndex]
        
        for (i in nums.size - 2 downTo 0) {
            val (maximum, minimum) = getMaxAndMin(
                nums[i], lastMax, lastMin
            )
            lastMax = maximum
            lastMin = minimum
            best = max(lastMax, best)
        }
        return best
    }    

    private fun getMaxAndMin(original: Int, dpMax: Int, dpMin: Int): Pair<Int, Int> {
        return if (original >= 0) {
            Pair(max(original, dpMax * original), 
                min(original, dpMin * original)
            )
        } else {
            Pair(max(original, dpMin * original), 
                min(original, dpMax * original)
            )
        }
    }
}
