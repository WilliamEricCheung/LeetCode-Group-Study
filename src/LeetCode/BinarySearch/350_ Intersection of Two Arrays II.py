class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        q = []
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 < n2:
            for i in nums1:
                if i in nums2:
                    q.append(i)
                    nums2.pop(nums2.index(i))
        else:
            for i in nums2:

                if i in nums1:
                    q.append(i)

                    nums1.pop(nums1.index(i))
        return q