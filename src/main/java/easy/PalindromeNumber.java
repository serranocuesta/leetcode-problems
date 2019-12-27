package easy;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        final String string = String.valueOf(x);
        final String reverse = reverse(string);
        return string.equals(reverse);
    }

    private String reverse(final String string) {
        return new StringBuilder(string).reverse().toString();
    }
}
