import kotlin.math.abs

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        for (asteroid in asteroids) {
            if (stack.isEmpty() || asteroid > 0 || stack.last() * asteroid > 0) {
                stack.add(asteroid)
            } else {
                destroy(stack, asteroid)
            }
        }
        return stack.toIntArray()
    }

    private fun destroy(stack: ArrayDeque<Int>, asteroid: Int) {
        while (stack.isNotEmpty() && stack.last * asteroid < 0) {
            val previousAsteroid = stack.last()
            if (abs(asteroid) > abs(previousAsteroid)) {
                stack.removeLast()
            } else if (abs(asteroid) == abs(previousAsteroid)) {
                stack.removeLast()
                return
            } else {
                return
            }
        }
        stack.add(asteroid)
    }
}