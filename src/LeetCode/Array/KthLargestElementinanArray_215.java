package LeetCode.Array;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementinanArray_215 {
    class SolutionQuickSelect {
        int[] nums;

        public int findKthLargest(int[] nums, int k) {
            this.nums = nums;
            int len = nums.length;
            return quickSelect(0, len - 1, len - k);
        }

        private void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private int randomPartition(int start, int end) {
            Random ran = new Random();
            int pivotIndex = start + ran.nextInt(end - start);
            int pivot = nums[pivotIndex];
            swap(pivotIndex, end);

            pivotIndex = start;
            for (int i = start; i <= end; i++) {
                if (nums[i] < pivot) {
                    swap(i, pivotIndex);
                    pivotIndex++;
                }
            }

            swap(pivotIndex, end);
            return pivotIndex;
        }

        private int quickSelect(int start, int end, int k) {
            if (start == end)
                return nums[start];

            int pivotIndex = randomPartition(start, end);
            if (pivotIndex == k)
                return nums[k];
            else if (pivotIndex < k)
                return quickSelect(pivotIndex + 1, end, k);
            else
                return quickSelect(start, pivotIndex - 1, k);
        }
    }

    class SolutionHeap {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> (n1 - n2));

            int size = 0;
            for (int i : nums) {
                heap.add(i);
                size++;
                if (size > k) {
                    heap.poll();
                    size--;
                }
            }

            return heap.poll();
        }
    }

    class Solution {
        /*
         * @param k : description of k
         * @param nums : array of nums
         * @return: description of return
         */
        public int kthLargestElement(int k, int[] nums) {
            if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
                return -1;
            }
            return partition(nums, 0, nums.length - 1, nums.length - k);
        }

        private int partition(int[] nums, int start, int end, int k) {
            if (start >= end) {
                return nums[k];
            }

            int left = start, right = end;
            int pivot = nums[(start + end) / 2];

            while (left <= right) {
                while (left <= right && nums[left] < pivot) {
                    left++;
                }
                while (left <= right && nums[right] > pivot) {
                    right--;
                }
                if (left <= right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }

            if (k <= right) {
                return partition(nums, start, right, k);
            }
            if (k >= left) {
                return partition(nums, left, end, k);
            }
            return nums[k];
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    };
}
