class Solution {
    fun isHappy(n: Int): Boolean {
        val history = mutableListOf<Int>()
        return isHappy(n, history)
    }

    private fun isHappy(n: Int, history: MutableList<Int>): Boolean {
        val zero = '0'
        return if (n == 1) {
            true
        } else if (n in history) {
            false
        } else {
            history.add(n)
            val x = n.toString().fold(0) { acc, c -> acc + (c - zero) * (c - zero) }
            isHappy(x, history)
        }
    }
}
