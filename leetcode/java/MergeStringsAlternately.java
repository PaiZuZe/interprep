class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        boolean leftTurn = true;
        while (i < word1.length() && j < word2.length()) {
            if (leftTurn) {
                sb.append(word1.charAt(i));
                i++;
            } else {
                sb.append(word2.charAt(j));
                j++;
            }
            leftTurn = !leftTurn;
        }
        if (i < word1.length()) {
            sb.append(word1.substring(i));
        } else {
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }
}
