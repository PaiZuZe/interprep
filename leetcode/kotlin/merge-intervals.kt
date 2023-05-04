import kotlin.math.max

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val newIntervals = mutableListOf<IntArray>()

        intervals.sortBy { it[0] }
        newIntervals.add(intervals[0])
        
        for (interval in intervals) {
            val lastInterval = newIntervals.last()
            if (interval[0] <= lastInterval[1]) {
                lastInterval[1] = max(lastInterval[1], interval[1])
            } else {
                newIntervals.add(interval)
            }
        }
        return newIntervals.toTypedArray()
    }
}
