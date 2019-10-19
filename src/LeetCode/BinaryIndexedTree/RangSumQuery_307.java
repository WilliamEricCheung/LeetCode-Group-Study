package LeetCode.BinaryIndexedTree;

public class RangSumQuery_307 {
    class NumArray {
        int[] fenwickTree;
        int[] nums_;

        public NumArray(int[] nums) {
            nums_ = new int[nums.length];
            fenwickTree = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                this.update(i, nums[i]);
            }
        }

        int lowBit(int i) {
            int complement = ~i + 1;
            return i & complement;
        }

        public void update(int i, int val) {
            int delta = val - nums_[i];
            nums_[i] = val;
            i += 1;
            while( i < fenwickTree.length) {
                fenwickTree[i] += delta;
                i += lowBit(i);
            }
        }

        
        
        public int sumRange(int i, int j) {
            int sumj = 0;
            for (int k = j + 1; k > 0; k -= lowBit(k))
                sumj += fenwickTree[k];
            int sumi = 0;
            for (int k = i; k > 0; k -= lowBit(k))
                sumi += fenwickTree[k];
            return sumj - sumi;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,9,5,7,3};
        RangSumQuery_307 cl = new RangSumQuery_307();
        NumArray obj = cl.new NumArray(nums);
        System.out.println(obj.sumRange(3, 3));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}

