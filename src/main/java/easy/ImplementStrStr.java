package easy;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;

        final char[] haystackChars = haystack.toCharArray();
        final char[] needleChars = needle.toCharArray();

        int needleIndex = 0;
        int candidateStart = 0;
        for (int i = 0; i < haystackChars.length; i++) {
            if (haystackChars[i] == needleChars[needleIndex]) {
                if (needleIndex == 0) {
                    candidateStart = i;
                }
                if (++needleIndex == needleChars.length) {
                    return candidateStart;
                }
            } else {
                if (needleIndex > 0) {
                    i = candidateStart; // Back to where we started recognising the pattern
                }
                needleIndex = 0;
            }
        }
        return -1;
    }

    public static void main(final String... args) {
        final ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("mississippi", "issip"));
    }
}
