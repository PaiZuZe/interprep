import java.util.ArrayList;
import java.util.List;

public class DecodeString {
    public String decodeString(String s) {
        char[] sCharArray = s.toCharArray();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < sCharArray.length; i++) {
            if (Character.isDigit(sCharArray[i])) {
                StringBuilder number = new StringBuilder();
                while (i < sCharArray.length && Character.isDigit(sCharArray[i])) {
                    number.append(sCharArray[i++]);
                }
                list.add(number.toString());
                i--;
            } else if (Character.isLetter(sCharArray[i])) {
                StringBuilder sequence = new StringBuilder();
                while (i < sCharArray.length && Character.isLetter(sCharArray[i])) {
                    sequence.append(sCharArray[i++]);
                }
                list.add(sequence.toString());
                i--;
            } else if (sCharArray[i] == '[') {
                StringBuilder subString = new StringBuilder();
                int bracketBalance = 1;
                i++;
                while (bracketBalance != 0) {
                    if (sCharArray[i] == '[') {
                        subString.append('[');
                        bracketBalance++;
                        i++;
                    } else if (sCharArray[i] == ']') {
                        bracketBalance--;
                        i++;
                        if (bracketBalance != 0) {
                            subString.append(']');
                        }
                    } else {
                        subString.append(sCharArray[i++]);
                    }
                }
               list.add(decodeString(subString.toString()));
                i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (Character.isDigit(str.charAt(0))) {
                int repeat = Integer.valueOf(str);
                sb.append(list.get(++i).repeat(repeat));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
