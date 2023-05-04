import kotlin.math.max

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val newIntervals = mutableListOf<IntArray>()
        var newIserted = false
        
        if (intervals.size == 0 || intervals[0][0] >= newInterval[0]) {
            newIntervals.add(newInterval)
            newIserted = true
        } else {
            newIntervals.add(intervals[0])
        }
        var lastInterval = newIntervals.last()

        var i = 0
        while (i < intervals.size) {
            val interval = intervals[i]
            if (!newIserted && newInterval[0] <= lastInterval[1]) {
                lastInterval[1] = max(lastInterval[1], newInterval[1])
                newIserted = true
                continue
            }
            if (interval[0] <= lastInterval[1]) {
                lastInterval[1] = max(lastInterval[1], interval[1])
                i++
                continue
            }
            if (!newIserted && newInterval[0] <= interval[0]) {
                newIntervals.add(newInterval)
                lastInterval = newInterval
                newIserted = true
                continue
            }
            lastInterval = interval
            newIntervals.add(interval)
            i++
        }
        if (!newIserted && newInterval[0] <= lastInterval[1]) {
            lastInterval[1] = max(lastInterval[1], newInterval[1])
            newIserted = true
        } else if (!newIserted) {
            newIntervals.add(newInterval)
        } 

        return newIntervals.toTypedArray()
    }
}

// private fun joinIntervals(intervals: Array<IntArray>, start: Int, end: Int): Array<IntArray> {
//     val newIntervals = mutableList<IntArray>()
//     for (i in 0 until start) {
//         newInterval.add(intervals[i])
//     }
//     newInterval.add()
// }

// private fun intervalBinSearchEnd(arr: Array<IntArray>, target: Int, start: Int, end: Int): Int {
//     if (end <= start) {
//         return end
//     }
//     val middle = ((end - start) / 2) + start
//     if (target >= arr[middle][0] && target <= arr[middle][1]) {
//         return middle
//     }
//     if (target < arr[middle][1]) {
//         return intervalBinSearch(arr, target, start, middle)
//     } else {
//         return intervalBinSearch(arr, target, middle + 1, end)
//     }
// }


fun main () {
    val sol = Solution()
    val arr = arrayOf<IntArray> (
        intArrayOf(1,2),
        intArrayOf(3,5),
        intArrayOf(6,7),
        intArrayOf(8,10),
        intArrayOf(12,16)
    )

    var target = 0
    println(sol.intervalBinSearch(arr, target, 0, arr.size))
    target = 1
    println(sol.intervalBinSearch(arr, target, 0, arr.size))
    target = 5
    println(sol.intervalBinSearch(arr, target, 0, arr.size))
    target = 11
    println(sol.intervalBinSearch(arr, target, 0, arr.size))
    target = 18
    println(sol.intervalBinSearch(arr, target, 0, arr.size))
}