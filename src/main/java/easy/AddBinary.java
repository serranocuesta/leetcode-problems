package easy;

public class AddBinary {

    public String addBinary(final String a, final String b) {
        final StringBuilder result = new StringBuilder();
        final char[] longer = a.length() >= b.length() ? reversedArray(a) : reversedArray(b);
        final char[] shorter = b.length() <= a.length() ? reversedArray(b) : reversedArray(a);

        int carriage = 0;

        for (int i = 0 ; i < longer.length ; i++) {
            final int operand1 = Character.getNumericValue(longer[i]);
            final int operand2 = i < shorter.length ? Character.getNumericValue(shorter[i]) : 0;
            final int[] sum = sum(operand1, operand2, carriage);
            result.append(sum[0]);
            carriage = sum[1];
        }

        if (carriage != 0) {
            result.append(carriage);
        }

        return result.reverse().toString();

    }

    private char[] reversedArray(final String a) {
        return new StringBuilder(a).reverse().toString().toCharArray();
    }

    public int[] sum(int a, int b, int c) {
        int sum = a + b + c;
        switch (sum) {
            case 0:
                return new int[]{0, 0};
            case 1:
                return new int[]{1, 0};
            case 2:
                return new int[]{0, 1};
            case 3:
                return new int[]{1, 1};
        }
        throw new RuntimeException();
    }

    public static void main(final String... args) {
        final AddBinary solution = new AddBinary();
        System.out.println(solution.addBinary("1", "1"));
        System.out.println(solution.addBinary("10", "10"));
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
    }
}
