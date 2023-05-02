class MinStack() {
    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.add(x)
        if (minStack.size == 0 || minStack.last() > x) {
            minStack.add(x)
        } else {
            minStack.add(minStack.last())
        }
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last() 
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */