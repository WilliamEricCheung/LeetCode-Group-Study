class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n<0:
            x=1/x
            n=-n
        if n==0:
            return 1
        if n==2:
            return x*x
        return self.myPow(self.myPow(x,n/2),2) if not n%2 else x*self.myPow(self.myPow(x,n//2),2)