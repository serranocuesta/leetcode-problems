package easy;

public class LengthLastWord {

    public int lengthOfLastWord(String s) {
        final String[] words = s.split(" ");
        if (words.length == 0) return 0;
        return words[words.length - 1].length();
    }

    public static void main(final String... args) {
        final LengthLastWord solution = new LengthLastWord();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}
