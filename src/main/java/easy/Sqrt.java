package easy;

public class Sqrt {

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public static void main(final String... args) {
        final Sqrt solution = new Sqrt();
        System.out.println(solution.mySqrt(4));
    }
}
