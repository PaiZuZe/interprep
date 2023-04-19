class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) {
            return listOf<Int>()
        }

        val pCharFrequencies = IntArray(26) { 0 }
        val sCharFrequencies = IntArray(26) { 0 }
        initCharFreqs(s, p, sCharFrequencies, pCharFrequencies)
        val resp = mutableListOf<Int>()
        for (i in 0 until (s.length - p.length)) {
            if (isAnagram(pCharFrequencies, sCharFrequencies)) {
                resp.add(i)
            }
            sCharFrequencies[s[i].toInt() - 'a'.toInt()]--
            sCharFrequencies[s[i + p.length].toInt() - 'a'.toInt()]++
        }
        if (isAnagram(pCharFrequencies, sCharFrequencies)) {
            resp.add(s.length - p.length)
        }
        return resp.toList()
    }

    private fun isAnagram(aCharFrequencies: IntArray, bCharFrequencies: IntArray): Boolean {
        for (i in aCharFrequencies.indices) {
            if (aCharFrequencies[i] != bCharFrequencies[i]) {
                return false
            }
        }
        return true
    }

    private fun initCharFreqs(s: String, p: String, sCharFrequencies: IntArray, pCharFrequencies: IntArray) {
        for (i in p.indices) {
            pCharFrequencies[p[i].toInt() - 'a'.toInt()]++
            sCharFrequencies[s[i].toInt() - 'a'.toInt()]++
        }
    }
}
