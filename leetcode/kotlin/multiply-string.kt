import kotlin.math.pow

class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }
        var carryOver: Int
        val resp = mutableListOf<Int>()
        val num1Rev = num1.reversed()
        val num2Rev = num2.reversed()
        for (i in num1Rev.indices) {
            val x = (num1Rev[i] - '0')
            carryOver = 0
            for (j in num2Rev.indices) {
                val y = num2Rev[j] - '0'
                val xy = x*y + carryOver
                if (resp.size == j + i) {
                    resp.add(0)
                }
                resp[j + i] += xy % 10                
                carryOver = xy / 10 + resp[j + i] / 10
                resp[j + i] = resp[j + i] % 10
            }
            if (carryOver != 0) {
                resp.add(carryOver)
            }
        }
        return resp.reversed().joinToString("")
    }
}

