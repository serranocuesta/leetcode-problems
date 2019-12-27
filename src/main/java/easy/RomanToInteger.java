package easy;

public class RomanToInteger {

    public static int romanToInt(final String s) {
        final char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return Roman.valueOf(chars[0]).getValue();
        }
        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            int value = Roman.valueOf(chars[i]).getValue();
            final int next = Roman.valueOf(chars[i + 1]).getValue();
            if (value < next) {
                result += (next - value);
                i++;
            } else {
                result += value;
            }
        }
        int last = Roman.valueOf(chars[chars.length - 1]).getValue();
        final int beforeLast = Roman.valueOf(chars[chars.length - 2]).getValue();
        if (beforeLast >= last) {
            result += last;
        }
        return result;
    }

    enum Roman {

        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

        private final int value;

        Roman(final int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static final Roman valueOf(final char c) {
            return valueOf(String.valueOf(c));
        }
    }

    public static void main(final String... args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
