import kotlin.math.min

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val amounts = IntArray(amount + 1) { Int.MAX_VALUE }
        amounts[0] = 0
        for (i in 1..amount) {
            for (coin in coins) {
                if (i >= coin) {
                    if (amounts[i - coin] != Int.MAX_VALUE) {
                        amounts[i] = min(amounts[i], amounts[i - coin] + 1)
                    }
                }
            }
        }
        return if (amounts[amount] == Int.MAX_VALUE) -1 else amounts[amount]
    }
}
