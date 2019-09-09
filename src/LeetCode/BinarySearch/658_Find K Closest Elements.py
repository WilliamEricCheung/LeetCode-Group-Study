class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        n=len(arr)
        left=0
        right=n-k
        while(right>left):
            mid=(left+right)//2
            if(x-arr[mid]>arr[mid+k]-x):
                left=mid+1
            else:
                right=mid
        return arr[left:left+k]