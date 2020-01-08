package easy;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return read(countAndSay(n - 1));
    }

    private String read(final String string) {
        final StringBuilder builder = new StringBuilder();
        final char[] chars = string.toCharArray();
        int i = 0;
        while (i < chars.length) {
            final char item = chars[i];
            final int count = count(item, chars, i);
            builder.append(count).append(item);
            i += count;
        }
        return builder.toString();
    }

    private int count(final char item, final char[] chars, final int offset) {
        int i = offset;
        while(i < chars.length && chars[i] == item) {
            i++;
        }
        return i - offset;
    }

    public static void main(final String... args) {
        final CountAndSay solution = new CountAndSay();
        System.out.println(solution.countAndSay(10));
    }
}
