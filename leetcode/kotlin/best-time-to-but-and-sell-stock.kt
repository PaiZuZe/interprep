class Solution {
    fun maxProfit(prices: IntArray): Int {
        var finalMinimum = Int.MAX_VALUE
        var finalMaximum = Int.MIN_VALUE
        var provisionalMinimum = Int.MAX_VALUE
        var provisionalMaximum = Int.MIN_VALUE
        for (price in prices) {
            if (provisionalMinimum > price) {
                provisionalMinimum = price
                provisionalMaximum = Int.MIN_VALUE
            } else if (provisionalMaximum < price) {
                provisionalMaximum = price
                if (finalMinimum == Int.MAX_VALUE || provisionalMaximum - provisionalMinimum > finalMaximum - finalMinimum) {
                    finalMaximum = provisionalMaximum
                    finalMinimum = provisionalMinimum
                }
            }
        }
        if (finalMinimum == Int.MAX_VALUE) {
            return 0
        }
        return finalMaximum - finalMinimum
    }
}
