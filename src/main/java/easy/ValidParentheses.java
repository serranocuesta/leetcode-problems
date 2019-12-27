package easy;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(final String s) {
        final Stack<Character> stack = new Stack<>();
        for (final Character c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) { // Closing a non-open
                return false;
            } else if (!isValidClose(stack.pop(), c)) { // Test if closes the previous char
                return false;
            }
        }
        return stack.isEmpty(); // Empty means all characters were matched
    }

    private static boolean isValidClose(final Character start, final Character close) {
        final Character valid;
        switch(start) {
            case '(':
                valid = ')'; break;
            case '{':
                valid = '}'; break;
            case '[':
                valid = ']'; break;
            default:
                throw new RuntimeException();
        }
        return valid == close;
    }

    private static boolean isOpen(final Character c) {
        return c == '(' || c == '{' || c == '[';
    }

    public static void main(final String... args) {
        System.out.println(isValid(""));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{[]}"));

        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
    }
}
