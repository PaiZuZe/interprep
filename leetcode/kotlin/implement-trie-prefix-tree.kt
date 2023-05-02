class Trie() {
    data class MapCell(val nextLevel: TrieLevel, var endsWith: Boolean)
    data class TrieLevel(val map: HashMap<Char, MapCell>)
    val firstLevel = TrieLevel(HashMap<Char, MapCell>())

    fun insert(word: String) {
        var level = firstLevel
        for (i in 0 until word.length) {
            val c = word[i]
            if (level.map[c] == null) {
                level.map[c] = MapCell(TrieLevel(HashMap<Char, MapCell>()), false)
            }
            if (i == word.length - 1) {
                level.map[c]!!.endsWith = true
            }
            level = level.map[c]!!.nextLevel
        }
    }

    fun search(word: String): Boolean {
        var level = firstLevel
        var endsWith = false
        word.forEach { c ->
            if (level.map[c] == null) {
                return false
            }
            endsWith = level.map[c]!!.endsWith
            level = level.map[c]!!.nextLevel
        }
        return endsWith
    }

    fun startsWith(prefix: String): Boolean {
        var level = firstLevel
        prefix.forEach { c ->
            if (level.map[c] == null) {
                return false
            }
            level = level.map[c]!!.nextLevel
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */