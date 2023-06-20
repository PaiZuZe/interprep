import java.math.BigInteger;

class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        String str1str2 = str1 + str2;
        String str2str1 = str2 + str1;
        if (!str1str2.equals(str2str1)) {
            return "";
        }
        int gcd = gcd(str1.length(), str2.length());
        return str1str2.substring(0, gcd);
    }

    static int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

}
