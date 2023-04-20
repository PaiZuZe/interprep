class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val charCount = IntArray(26) { 0 }
        tasks.forEach {c -> charCount[c - 'A'] += 1}
        charCount.sort()
        val max = charCount[charCount.lastIndex]
        return (max - 1) * (n + 1) + 1
    }
}