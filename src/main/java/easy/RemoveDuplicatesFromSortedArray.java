package easy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        final Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        final List<Integer> list = set.stream()
                .sorted()
                .collect(Collectors.toList());
        for(int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return set.size();
    }

    public int removeDuplicates2(int[] nums)
    {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1 ; j < nums.length; j++ )
        {
            if (nums[j] != nums[i])
            {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(final String... args) {
        final RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{-1, -1, 1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
