import kotlin.math.max

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var start = 0
        var resp = 0
        val freqs = IntArray(26) { 0 }
        for (end in 0..s.length) {
            if ((end - start) - freqs.max()!! > k) {
                resp = max(resp, end - start - 1)
                freqs[s[start].toInt() - 'A'.toInt()]--
                start++
            } else {
                resp = max(resp, end - start)
            }
            if (end != s.length) {
                freqs[s[end].toInt() - 'A'.toInt()]++
            }
        }
        return resp
    }
}
