import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var resp = 0
        val charPos = HashMap<Char, Int>()
        var start = -1
        s.forEachIndexed { i, c ->
            if (charPos[c] != null && charPos[c]!! > start) {
                start = charPos[c]!!
            }
            resp = max(resp, i - start)
            charPos[c] = i
        }
        return resp
    }
}

fun main() {
    val sol = Solution()
    val a = "abcabcbb"
    println(sol.lengthOfLongestSubstring(a) == 3)

    val b = "bbbbb"
    println(sol.lengthOfLongestSubstring(b) == 1)

    val c = "pwwkew"
    println(sol.lengthOfLongestSubstring(c) == 3)

    val d = "tmmzuxt"
    println(sol.lengthOfLongestSubstring(d) == 5)
}