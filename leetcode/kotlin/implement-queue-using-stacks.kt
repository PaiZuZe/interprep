class MyQueue() {
    val pushStack = ArrayDeque<Int>()
    val popStack = ArrayDeque<Int>()

    fun push(x: Int) {
        pushStack.add(x)
    }

    fun pop(): Int {
        if (popStack.isEmpty()) {
            pushToPop()
        }
        return popStack.removeLast()
    }

    fun peek(): Int {
        if (popStack.isEmpty()) {
            pushToPop()
        }
        return popStack.last()
    }

    fun empty(): Boolean {
        return pushStack.isEmpty() && popStack.isEmpty()
    }

    private fun pushToPop() {
        while (pushStack.isNotEmpty()) {
            val x = pushStack.removeLast()
            popStack.add(x)
        }
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */