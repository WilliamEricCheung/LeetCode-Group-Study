package LeetCode.BinarySearch;

public class FindFirstandLastPositionofElementinSortedArray_34 {
    class Solution {
        int[] nums_;
        int key;
        public int[] searchRange(int[] nums, int target) {
            nums_ = nums;
            key = target;
            int[] ans = new int[2];
            return ans = BinarySearch(0, nums.length - 1);
        }

        public int[] BinarySearch(int start, int end) {
            if (start > end)    return new int[]{-1, -1};
            int medium = (start + end) / 2;
            int m = nums_[medium];
            if (m < key)    return BinarySearch(medium + 1, end);
            else if (m > key) return BinarySearch(start, medium - 1);
            else {
                int left = findLeftBoundary(start, medium);
                int right = findRightBoundary(medium, end);
                return new int[] {left, right};
            }
        }

        public int findLeftBoundary(int start, int end) {
            if (start == end)   return start;
            int medium = (start + end) / 2;
            int m = nums_[medium];
            if (m == key)   return findLeftBoundary(start, medium);
            else if (nums_[medium + 1] == key)  return medium + 1;
            else return findLeftBoundary(medium + 1, end);
        }

        public int findRightBoundary(int start, int end) {
            if (start == end)   return start;
            int medium = (start + end + 1) / 2;
            int m = nums_[medium];
            if (m == key)   return findRightBoundary(medium, end);
            else if (nums_[medium - 1] == key)  return medium - 1;
            else return findRightBoundary(start, medium - 1);
        }
    }

    public static void main(String[] args) {
        FindFirstandLastPositionofElementinSortedArray_34 cl = new FindFirstandLastPositionofElementinSortedArray_34();
        Solution sl = cl.new Solution();

        int[] nums = new int[] {5,7,7,8,8,10};
        int target = 8;
        int[] ans = sl.searchRange(nums, target);
        System.out.println(ans);
    }
}
