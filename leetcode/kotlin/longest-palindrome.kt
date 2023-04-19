class Solution {
    fun longestPalindrome(s: String): Int {
        var length = 0
        val frequencies = IntArray(255) { 0 }
        s.forEach { c -> frequencies[c.toInt()] += 1 }
        var single = false
        frequencies.forEach { frequency -> 
            length += if (frequency % 2 == 1) {
                single = true
                frequency - 1
            } else {
                frequency
            }
        }
        return length + if (single) 1 else 0
    }
}
