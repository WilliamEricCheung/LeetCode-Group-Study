class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1
        n=len(nums)-1
        min_start=nums.index(min(nums))
        if  not nums[min_start]<=target<=nums[n]:
            n=min_start
            min_start=0
        while(n>=min_start):
            mid=(n+min_start)//2
            if(nums[mid]==target):
                return mid
            elif(nums[mid]<target):
                min_start=mid+1
            else:
                n=mid-1
        return -1