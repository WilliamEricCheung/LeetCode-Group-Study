package LeetCode.HashTable;

import java.util.*;

public class TwoSumIII_170 {
    //mine
    class TwoSumMine {
        private HashMap<Integer, Integer> map;

        /** Initialize your data structure here. */
        public TwoSumMine() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (map.containsKey(number)) {
                int count = map.get(number);
                map.put(number, ++count);
            }
            else
                map.put(number, 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (int num: map.keySet()) {
                int complement = value - num;
                if (complement == num) {
                    if (map.get(num) > 1)
                        return true;
                }
                else if (map.containsKey(complement))
                    return true;
            }
            return false;
        }
    }


    class TwoSumSolution {
        private HashMap<Integer, Integer> num_counts;

        /** Initialize your data structure here. */
        public TwoSumSolution() {
            this.num_counts = new HashMap<Integer, Integer>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (this.num_counts.containsKey(number))
                this.num_counts.replace(number, this.num_counts.get(number) + 1);
            else
                this.num_counts.put(number, 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : this.num_counts.entrySet()) {
                int complement = value - entry.getKey();
                if (complement != entry.getKey()) {
                    if (this.num_counts.containsKey(complement))
                        return true;
                } else {
                    if (entry.getValue() > 1)
                        return true;
                }
            }
            return false;
        }
    }

    class TwoSumTwoPointers {
        private ArrayList<Integer> nums;
        private boolean is_sorted;

        /** Initialize your data structure here. */
        public TwoSumTwoPointers() {
            this.nums = new ArrayList<Integer>();
            this.is_sorted = false;
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            this.nums.add(number);
            this.is_sorted = false;
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            if (!this.is_sorted) {
                Collections.sort(this.nums);
            }
            int low = 0, high = this.nums.size() - 1;
            while (low < high) {
                int twosum = this.nums.get(low) + this.nums.get(high);
                if (twosum < value)
                    low += 1;
                else if (twosum > value)
                    high -= 1;
                else
                    return true;
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
