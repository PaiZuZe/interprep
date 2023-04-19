class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var j = 0
        for (i in t.indices) {
            if (j == s.length) {
                return true
            }
            if (t[i] == s[j]) {
                j++
            }
        }
        return j == s.length
    }
}
