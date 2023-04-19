class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val sToT = hashMapOf<Char, Char>()
        val tToS = hashMapOf<Char, Char>()
        for (i in s.indices) {
            if (sToT[s[i]] == null && tToS[t[i]] == null) {
                sToT[s[i]] = t[i]
                tToS[t[i]] = s[i]
            } else if (sToT[s[i]] != t[i] && tToS[t[i]] != s[i]) {
                return false
            }
        }
        return true
    }
}
