package easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        return plusOne(digits, digits.length - 1);
    }

    private int[] plusOne(int [] digits, int position) {
        digits[position] = (digits[position] + 1) % 10;
        if (digits[position] != 0) {
            return digits;
        }
        if (position == 0) { // Overflow
            return overflown(digits);
        }
        return plusOne(digits, --position);
    }

    private int[] overflown(final int[] digits) {
        final int[] overflown = new int[digits.length + 1];
        overflown[0] = 1;
        return overflown;
    }

    public static void main(final String... args) {
        final PlusOne solution = new PlusOne();
        System.out.println(Arrays.stream(solution.plusOne(new int[]{1, 2, 3, 9})).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(solution.plusOne(new int[]{1, 2, 9, 9})).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(solution.plusOne(new int[]{0})).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(solution.plusOne(new int[]{9})).boxed().collect(Collectors.toList()));
    }
}
