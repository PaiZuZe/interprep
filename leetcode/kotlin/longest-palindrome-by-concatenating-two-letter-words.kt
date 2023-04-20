class Solution {
    fun longestPalindrome(words: Array<String>): Int {
        val frequencies = HashMap<String, Int>()
        words.forEach { word -> frequencies[word] = (frequencies[word] ?: 0) + 1 }
        
        var count = 0
        var middle = false
        
        frequencies.forEach { word, freq ->
            if (word == word.reversed()) {
                count += freq / 2
                if (!middle && freq % 2 == 1) {
                    middle = true
                }
            } else {
                count += min(freq, (frequencies[word.reversed()] ?: 0))
            }
        }
        return count * 4 + if (middle) 2 else 0
    }
}