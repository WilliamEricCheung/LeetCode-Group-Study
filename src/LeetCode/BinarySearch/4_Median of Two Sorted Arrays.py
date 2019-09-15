class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if not nums1:
            nums3=nums2
        if not nums2:
            nums3=nums1
        else:
            nums3=(nums1+nums2)
        nums3.sort()
        n=len(nums3)-1
        mid=n//2
        print (nums3)
        print (mid)
        if(n%2==0):
            return nums3[mid]
        else:
            return (nums3[mid]+ nums3[mid+1])/2