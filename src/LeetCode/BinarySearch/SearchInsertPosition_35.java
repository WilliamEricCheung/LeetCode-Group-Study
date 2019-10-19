package LeetCode.BinarySearch;

public class SearchInsertPosition_35 {
    class Solution {
        int[] nums_;
        int key;

        public int searchInsert(int[] nums, int target) {
            nums_ = nums;
            key = target;
            return binarySearch(0, nums.length - 1);
        }

        public int binarySearch(int start, int end) {
//            if (start == end) {
//                if (nums_[start] < key) return start + 1;
//                else return start;
//            }
            if (start > end)    return end;

            int medium = (start + end) / 2;
            if (nums_[medium] > key)    return binarySearch(start, medium);
            else if (nums_[medium] < key)   return binarySearch(medium + 1, end);
            else if (nums_[medium] == key)  return medium;
            return -1;
        }
    }
}
