class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val toFrom = prerequisitesToToFrom(prerequisites, numCourses)
        val formatedPrerequisites = formatPrerequisites(prerequisites, numCourses)
        val path = dfs(toFrom, formatedPrerequisites)
        return if (path.size == numCourses) {
            path
        } else {
            intArrayOf()
        }
    }

    private fun dfs(toFrom: Array<IntArray>, prerequisites: Array<IntArray>): IntArray {
        val n = toFrom.size
        val visited = BooleanArray(n) { false }
        val frontier = ArrayDeque<Int>()
        val path = mutableListOf<Int>()
        prerequisites.forEachIndexed { i, it ->
            if (it.size == 0) {
                frontier.add(i)
            }
        }

        while (frontier.isNotEmpty()) {
            val course = frontier.removeLast()
            if (visited[course]) {
                continue
            }
            visited[course] = true
            path.add(course)
            val validNeighboors = getValidNeighboors(course, toFrom, prerequisites, visited)
            
            validNeighboors.forEach { neighboor ->
                frontier.add(neighboor)
            }
        }
        return path.toIntArray()
    }

    private fun getValidNeighboors(course: Int, toFrom: Array<IntArray>, prerequisites: Array<IntArray>, visited: BooleanArray): List<Int> {
        return toFrom[course]
            .filter { !visited[it] && 
                prerequisites[it].filter{ preq -> !visited[preq] }.size == 0
            }
    }

    private fun prerequisitesToToFrom(prerequisites: Array<IntArray>, n: Int): Array<IntArray> {
        val toFrom = Array<MutableList<Int>>(n) { mutableListOf<Int>() }
        for (prerequisit in prerequisites) {
            toFrom[prerequisit[1]].add(prerequisit[0])
        }
        return Array(n) { toFrom[it].toIntArray() }
    }

    private fun formatPrerequisites(prerequisites: Array<IntArray>, n: Int): Array<IntArray> {
        val toFrom = Array<MutableList<Int>>(n) { mutableListOf<Int>() }
        for (prerequisit in prerequisites) {
            toFrom[prerequisit[0]].add(prerequisit[1])
        }
        return Array(n) { toFrom[it].toIntArray() }
    }
}

fun main() {
    val sol = Solution()

    val preqs = arrayOf<IntArray>( 
        intArrayOf(1, 0),
        intArrayOf(2, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2)
    )

    println(sol.findOrder(4, preqs).joinToString(" "))
}