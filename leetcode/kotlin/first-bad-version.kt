/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var lo = 1
        var hi = n
        var middle: Int
        while (true) {
            middle = lo + (hi - lo + 1) / 2
            if (isBadVersion(middle) && !isBadVersion(middle - 1)) {
                return middle
            }
            if (isBadVersion(middle)) {
                hi = middle
            } else {
                lo = middle
            }
        }
    }
}
