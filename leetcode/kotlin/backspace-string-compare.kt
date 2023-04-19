class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        val sStack = CharArray(s.length)
        val tStack = CharArray(t.length)
        
        val sStackTop = stackLetters(s, sStack)
        val tStackTop = stackLetters(t, tStack)

        return compareStacks(sStack, sStackTop, tStack, tStackTop)
    }

    private fun compareStacks(sStack: CharArray, sStackSize: Int, tStack: CharArray, tStackSize: Int): Boolean {
        if (sStackSize != tStackSize) {
            return false
        }
        for (i in 0 until sStackSize) {
            if (sStack[i] != tStack[i]) {
                return false
            }
        }
        return true
    }

    private fun stackLetters(s: String, stack: CharArray): Int {
        var top = 0
        for (c in s) {
            if (c == '#' && top > 0) {
                top--
            } else if (c != '#') {
                stack[top++] = c
            }
        }
        return top
    }
}
