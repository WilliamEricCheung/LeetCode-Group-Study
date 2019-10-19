package LeetCode.BinaryIndexedTree;

import java.util.*;

public class CountofSmallerNumbersAfterSelf_315 {
    class Solution {
        private class fenwickTree {
            int[] tree;

            fenwickTree(int size) {
                tree = new int[size];
            }

            public void update(int i, int delta) {
                for (int j = i; j < tree.length; j += j & -j) {
                    tree[j] += delta;
                }
            }

            public int query(int i, int j) {
                int sumi = 0;
                for (int k = i; k > 0; k -= k & -k) {
                    sumi += tree[k];
                }

                int sumj = 0;
                for (int k = j; k > 0; k -= k & -k) {
                    sumj += tree[k];
                }

                return sumj - sumi;
            }
        }

        //api: Arrays.copyOf(array, length);
        //Map: tow interface: Map and Sorted Map; three classes: HashMap, TreeMap; Linked HashMap
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            if (nums.length == 0)   return ans;
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            Map<Integer, Integer> ranks = new HashMap<>();
            ranks.put(sorted[0], 1);
            for(int i = 1, rank = 1; i < sorted.length; i++) {
                if (sorted[i] != sorted[i - 1])
                    ranks.put(sorted[i], ++rank);
            }

            fenwickTree obj = new fenwickTree(ranks.size() + 1);
            for (int i = nums.length - 1; i >= 0; i--) {
                int rank = ranks.get(nums[i]);
                ans.add(obj.query(0, rank - 1));
                obj.update(rank, 1);
            }

            Collections.reverse(ans);
            return ans;
        }
    }
}
