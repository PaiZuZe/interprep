class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 3) {
            return n
        }
        val steps = IntArray(2) { it + 2 }
        for (i in 4..n) {
            val temp = steps[1] + steps[0]
            steps[0] = steps[1]
            steps[1] = temp
        }
        return steps[1]
    }
}
