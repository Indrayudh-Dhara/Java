
    import java.util.Stack;

class Solution {
    /**
     * Decodes an encoded string based on the given pattern.
     *
     * @param s The encoded string.
     * @return The decoded string.
     */
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // Handle multi-digit numbers
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(currentString);
                currentString = new StringBuilder(); // Reset for the inner string
                num = 0; // Reset number
            } else if (ch == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder decodedString = strStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString; // Update current string
            } else {
                currentString.append(ch); // Append regular characters
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString(" 3[b2[v]]L"));
    }
}
