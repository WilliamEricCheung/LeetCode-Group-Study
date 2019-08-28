public class rotatearray {
public void reverse (int[] arr, int start, int end){
    while(start < end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
 }

public int rotate(int[] nums, int k){
 int n = nums.length;
 k %= n;
 reverse(nums, 0, n-1);
 reverse(nums, 0, k-1);
 reverse(nums, k,n-1);
 }
}
