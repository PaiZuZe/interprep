class Solution {
    fun decodeString(s: String): String {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            if (c == ']') {
                restack(stack)
            } else {
                stack.add(c)
            }
        }
        return stack.joinToString("")
    }

    private fun restack(stack: ArrayDeque<Char>) {
        val tmpStack = ArrayDeque<Char>()
        while (stack.last() != '[') {
            tmpStack.add(stack.removeLast())
        }
        val tmpString = tmpStack.joinToString("").reversed()
        stack.removeLast()
        val tmpMultStack = ArrayDeque<Char>()
        while (stack.lastOrNull() in '0'..'9') {
            tmpMultStack.add(stack.removeLast())
        }
        val tmpMult = tmpMultStack.joinToString("").reversed().toIntOrNull() ?: 1
        stack.addAll(tmpString.repeat(tmpMult).toList())
    }
}
