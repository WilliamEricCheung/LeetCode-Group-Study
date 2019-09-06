class Solution:
    def mySqrt(self, x: int) -> int:
        if(x==0):
            return 0
        left=1
        right=x
        mid=0
        while right>=left:
            mid=(left+right)//2
            if(mid**2==x):
                return mid
            elif(mid**2<x):
                left=mid+1
            elif(mid**2>x):
                right=mid-1
        if(mid**2>x):
            return mid-1
        return mid