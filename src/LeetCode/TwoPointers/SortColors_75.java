package LeetCode.TwoPointers;

public class SortColors_75 {
    class SolutionPartition {
        public void sortColors(int[] nums) {
            int red = 0, white, blue;

            while (red < nums.length) {
                if (nums[red] > 0)
                    break;
                red++;
            }

            white = red;
            while (white < nums.length) {
                if (nums[white] > 1)
                    break;
                white++;
            }

            blue = white;
            while (blue < nums.length) {
                if (nums[blue] < 2) {
                    swap(nums, white, blue);
                    if (nums[white] == 0) {
                        swap(nums, red, white);
                        red++;
                    }
                    white++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

        }
    }

    class SolutionTwoPointers {
        public void sortColors(int[] a) {
            if (a == null || a.length <= 1) {
                return;
            }

            int pl = 0;
            int pr = a.length - 1;
            int i = 0;
            while (i <= pr) {
                //left of i could only be 0 or 1
                if (a[i] == 0) {
                    swap(a, pl, i);
                    pl++;
                    i++;
                } else if(a[i] == 1) {
                    i++;
                } else {
                    swap(a, pr, i);
                    pr--;
                }
                //after swapping pr and i, a[i] could be 1 or 0, may need another swap
            }
        }

        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
