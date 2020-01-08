package easy;

import java.util.stream.IntStream;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(final int[] nums, final int start, final int end) {
        if (start == end) {
            return nums[start];
        }
        final int middle = (start + end) / 2;

        final int leftSum = maxSubArray(nums, start, middle);
        final int rightSum = maxSubArray(nums, middle + 1, end);
        final int middleSum = maxSubArray(nums, start, middle, end);

        return IntStream.of(leftSum, middleSum, rightSum)
                .max()
                .orElseThrow(() -> new RuntimeException("Unable to find"));
    }

    private int maxSubArray(final int[] nums, final int start, final int middle, final int end) {
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = middle; i >= start ; i--) {
            sum += nums[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        sum = 0;
        int rightMax = Integer.MIN_VALUE;
        for (int i = middle + 1; i <= end ; i++) {
            sum += nums[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }
        return leftMax + rightMax;
    }

    public static void main(final String... args) {
        final MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[] {-1,0,-2}));
        System.out.println(solution.maxSubArray(new int[] {-2,-1}));
    }
}
