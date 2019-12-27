package easy;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(final String... strs) {
        if(strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            commonPrefix = commonPrefix(commonPrefix, strs[i]);
            if (commonPrefix.length() == 0) {
                return "";
            }
        }
        return commonPrefix;
    }

    public static String commonPrefix(final String s1, final String s2) {
        final int shortestLength = s1.length() > s2.length() ? s2.length() : s1.length();
        final StringBuilder common = new StringBuilder();
        for(int i = 0; i < shortestLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return common.toString();
            }
            common.append(s1.charAt(i));
        }
        return common.toString();
    }

    public static void main(final String... args) {
        System.out.println(longestCommonPrefix("flower","flow","flight"));
        System.out.println(longestCommonPrefix("dog","racecar","car"));
    }
}
