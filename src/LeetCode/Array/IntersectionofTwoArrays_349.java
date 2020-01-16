package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays_349 {
    class SolutionHash {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> ans = new HashSet<>(0);
            int m = nums1.length, n = nums2.length;
            Set<Integer> set = new HashSet<>();
            if (m < n) {
                for (int i = 0; i < m; i++) {
                    set.add(nums1[i]);
                }
                for (int i = 0; i < n; i++) {
                    if (set.contains(nums2[i]))
                        ans.add(nums2[i]);
                }

            }
            else {
                for (int i = 0; i < n; i++) {
                    set.add(nums2[i]);
                }
                for (int i : nums1) {
                    if (set.contains(i))
                        ans.add(i);
                }
            }
            int[] output = new int[ans.size()];
            int index = 0;
            for (Integer i : ans) {
                output[index++] = i;
            }
            return output;
        }
    }

    class SolutionSort {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            Set<Integer> ans = new HashSet<>();
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    ans.add(nums1[i]);
                    i++;
                    j++;
                }
                else if (nums1[i] < nums2[j])
                    i++;
                else
                    j++;
            }

            int[] output = new int[ans.size()];
            int index = 0;
            for (Integer num : ans)
                output[index++] = num;
            return output;
        }
    }

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }

            Arrays.sort(nums1);
            Set<Integer> ans = new HashSet<>();
            for (int i = 0; i < nums2.length; i++) {
                int start = 0, end = nums1.length - 1;
                while (start + 1 < end) {
                    int med = start + (end - start) / 2;
                    if (nums1[med] == nums2[i]) {
                        ans.add(nums2[i]);
                        break;
                    }
                    if (nums1[med] < nums2[i]) {
                        start = med;
                    }
                    else
                        end = med;
                }
                if (nums1[start] == nums2[i] || nums1[end] == nums2[i])
                    ans.add(nums2[i]);
            }

            int[] output = new int[ans.size()];
            int index = 0;
            for (Integer i : ans) {
                output[index++] = i;
            }
            return output;
        }
    }
}
