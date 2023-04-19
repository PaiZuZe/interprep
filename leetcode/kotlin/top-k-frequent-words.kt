class Solution {
    

    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val freq = mutableMapOf<String, Int>()
        val pq = PriorityQueue<String> { s: String, t: String -> comparator(s, t, freq) }
        
        words.forEach { word -> freq[word] = (freq[word] ?: 0) + 1 }
        freq.keys.forEach { word -> pq.add(word)}
        return List<String>(k) { pq.poll() }
    }

    private fun comparator(s: String, t: String, freq: MutableMap<String, Int>): Int {
        val diff = (freq[t] ?: 0) - (freq[s] ?: 0)
        if (diff != 0) {
            return diff
        } else {
            return s.compareTo(t)
        }
    }
}
