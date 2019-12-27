package easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(final String... args) {
        final RemoveElement removeElement = new RemoveElement();
        int[] nums = new int[]{-1, -1, 1, 2, 2, 2, 3, 4, 4, 5, 5};
        System.out.println(removeElement.removeElement(nums, 5));
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
