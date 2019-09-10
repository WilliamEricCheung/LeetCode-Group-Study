class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        left=1
        right=num
        while(right>left):
            mid=(left+right)//2
            ans=mid**2
            if(ans>num):
                right=mid-1
            elif(ans==num):
                return True
            else:
                left=mid+1
        if(left**2==num):
            return True
        return False