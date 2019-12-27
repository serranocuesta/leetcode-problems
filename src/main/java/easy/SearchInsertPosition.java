package easy;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        if (target == nums[nums.length - 1]) return nums.length - 1;
        if (target > nums[nums.length - 1]) return nums.length;
        for (int i = 0 ; i < nums.length -1 ; i++) {
            if (isPosition(nums, i, target)) {
                return i + 1;
            }
        }
        throw new RuntimeException("Unable to find position");
    }

    private boolean isPosition(final int[] nums, final int index, final int target) {
        return nums[index] <= target && nums[index + 1] >=target;
    }

    public static void main(final String... args) {
        final SearchInsertPosition solution = new SearchInsertPosition();
        System.out.println(solution.searchInsert(new int[]{1, 3}, 3));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
