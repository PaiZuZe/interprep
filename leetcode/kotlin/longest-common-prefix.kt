class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val minLegth = strs.map { it.length }.min() ?: 0
        for (i in 0 until minLegth) {
            for (str in strs) {
                if (str[i] != strs[0][i]) {
                    return strs[0].take(i)
                }
            }
        }
        return strs[0].take(minLegth)
    }
}
