class Solution {
    fun calculate(s: String): Int {
        val rpn = toReversePolishNotation(toList(s))
        val stack = ArrayDeque<Int>()
        for (x in rpn) {
            if (x in "+-*/") {
                val operand2 = stack.removeLast()
                val operand1 = stack.removeLast()
                val result = when (x) {
                    "-" -> operand1 - operand2
                    "/"  -> operand1 / operand2
                    "+" -> operand1 + operand2
                    "*" -> operand1 * operand2
                    else -> operand1
                }
                stack.add(result)
            } else {
                stack.add(x.toInt())
            }
        }

        return stack.last().toInt()
    }

    private fun toReversePolishNotation(list: List<String>): List<String> {
        val rpn = ArrayDeque<String>()
        val operators = ArrayDeque<String>()
        for (op in list) {
            if (op in "-+*/") {
                while (operators.size > 0 && hasLowerPrecedence(op, operators.last())) {
                    rpn.add(operators.removeLast())
                }
                operators.add(op)
            } else {
                rpn.add(op)
            }
        }
        while (operators.isNotEmpty()) {
            rpn.add(operators.removeLast())
        }
        return rpn.toList()
    }

    private fun hasLowerPrecedence(operator1: String, operator2: String): Boolean {
        if (operator1 in "*/" && operator2 in "+-") {
            return false
        }
        return true
    }

    private fun toList(s: String): List<String> {
        val list = mutableListOf<StringBuilder>()
        for (c in s) {
            if (c in "+-*/") {
                list.add(StringBuilder(c.toString()))
            } else if (c in '0'..'9') {
                if (list.size == 0 || list.last().toString() in "+-*/") {
                    list.add(StringBuilder(c.toString()))
                } else {
                    list.last().append(c)
                }
            }
        }
        return list.map { it.toString() }
    }
}

fun main() {
    val sol = Solution()
    
    val s1 = "3+2*2"
    val s2 = " 3/2 "
    val s3 = " 3+5 / 2 "
    val s4 = "0-2147483647"
    val s5 = "1-1+1"
    val s6 = "1-1-1"
    val s7 = "1*2-3/4+5*6-7*8+9/10"


    val resp1 = sol.calculate(s1)
    println("resp: $resp1 is expected: ${ resp1 == 7 }")
    val resp2 = sol.calculate(s2)
    println("resp: $resp2 is expected: ${ resp2 == 1 }")
    val resp3 = sol.calculate(s3)
    println("resp: $resp3 is expected: ${ resp3 == 5 }")
    val resp4 = sol.calculate(s4)
    println("resp: $resp4 is expected: ${ resp4 == -2147483647 }")
    val resp5 = sol.calculate(s5)
    println("resp: $resp5 is expected: ${ resp5 == 1 }")
    val resp6 = sol.calculate(s6)
    println("resp: $resp6 is expected: ${ resp6 == -1 }")
    val resp7 = sol.calculate(s7)
    println("resp: $resp7 is expected: ${ resp7 == -24 }")
}