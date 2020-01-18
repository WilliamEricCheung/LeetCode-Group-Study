package LeetCode.Array;

public class PartitionArrayintoDisjointIntervals_915 {
    class SolutionUsingArrays {
        public int partitionDisjoint(int[] A) {
            int[] min = new int[A.length];
            int[] max = new int[A.length];

            int currMin = Integer.MAX_VALUE;
            for (int i = A.length - 1; i >= 0; i--) {
                if (A[i] < currMin)
                    currMin = A[i];
                min[i] = currMin;
            }

            int currMax = Integer.MIN_VALUE;
            for (int i = 0; i < A.length; i++) {
                if (A[i] > currMax)
                    currMax = A[i];
                max[i] = currMax;
            }

            for (int i = 0; i < A.length - 1; i++) {
                if (max[i] <= min[i + 1])
                    return i + 1;
            }
            return 0;
        }
    }

    class SolutionOnePass {
        public int partitionDisjoint(int[] a) {
            int localMax = a[0], partitionIdx = 0, max = localMax;
            for (int i = 1; i < a.length; i++)
                if (localMax > a[i]) {
                    localMax = max;
                    partitionIdx = i;
                } else max = Math.max(max, a[i]);
            return partitionIdx + 1;
        }
    }
}
