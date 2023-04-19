class Solution {
    fun fib(n: Int): Int {
        val fib = mutableListOf<Int>()
        fib.addAll(listOf(0, 1))
        if (n <= 1) {
            return fib[n]
        }
        for (i in 2..n) {
            val newFib = fib[1] + fib[0]
            fib[0] = fib[1]
            fib[1] = newFib
        }
        return fib[1]
    }
}
