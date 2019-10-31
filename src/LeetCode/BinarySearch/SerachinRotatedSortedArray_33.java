package LeetCode.BinarySearch;

public class SerachinRotatedSortedArray_33 {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0)   return -1;
            int start = 0, end = nums.length - 1;
            int mid;
            while(start + 1 < end) {
                mid = (end - start) / 2 + start;
                if (nums[mid] == target)    return mid;
                if (nums[mid] >= nums[start]) {
                    if (target >= nums[start] && target <= nums[mid])
                        end = mid;
                    else start = mid;
                }
                else {
                    if (target >= nums[mid] && target <= nums[end])
                        start = mid;
                    else end = mid;
                }
            }

            if (nums[start] == target)  return start;
            else if (nums[end] == target)   return end;
            else return -1;
        }
    }

    public static void main(String[] args) {
        SerachinRotatedSortedArray_33 cl = new SerachinRotatedSortedArray_33();
        Solution sl = cl.new Solution();
        int[] nums = {5, 1, 3};
        int target = 5;
        System.out.println(sl.search(nums, target));
    }
}
