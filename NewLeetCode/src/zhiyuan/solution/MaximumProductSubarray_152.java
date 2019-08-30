package zhiyuan.solution;

/**
 * ClassName:MaximumProductSubarray_152
 * PackgeName:zhiyuan.solution
 * Description:
 *
 * @Date:2019-08-30 13:39
 * Author:ningzhy3@gmail.com
 */
public class MaximumProductSubarray_152 {

    public int MaximumProductSubarray_152(int nums[]) {

        int maxC = nums[0], minC = nums[0], product = nums[0];
        int maxNext = 0, minNext = 0;
        for (int i = 1; i < nums.length; i++) {
            maxNext = maxC * nums[i];
            minNext = minC * nums[i];
            maxC = Math.max(Math.max(maxNext,minNext),nums[i]);
            minC = Math.min(Math.min(maxNext,minNext),nums[i]);
            product = Math.max(maxC,product);

        }
        return product;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {2,3,-2,4};
        MaximumProductSubarray_152 result = new MaximumProductSubarray_152();
        System.out.println(result.MaximumProductSubarray_152(nums));
    }

}
