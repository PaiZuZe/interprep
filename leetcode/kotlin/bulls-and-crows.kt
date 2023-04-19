class Solution {
    fun getHint(secret: String, guess: String): String {
        val secretCount = IntArray(10) { 0 }
        val guessCount = IntArray(10) { 0 }
        val bullCount = IntArray(10) { 0 }

        for (i in secret.indices) {
            if (secret[i] == guess[i]) {
                bullCount[secret[i] - '0']++
            }
            secretCount[secret[i] - '0']++
            guessCount[guess[i] - '0']++
        }
        val bulls: Int = bullCount.sum()
        var cows = 0
        for (i in 0..9) {
            cows += minOf(secretCount[i], guessCount[i]) - bullCount[i]
        }
        return "${ bulls }A${ cows }B"
    }
}
