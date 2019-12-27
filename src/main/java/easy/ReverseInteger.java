package easy;

public class ReverseInteger {

    public int reverse(int x) {
        try {
            final int abs = Math.abs(x);
            final StringBuilder builder = new StringBuilder(String.valueOf(abs));
            final int reverse = Integer.valueOf(builder.reverse().toString());
            return x < 0 ? -reverse : reverse;
        } catch (final Exception e) {
            return 0;
        }
    }
}
