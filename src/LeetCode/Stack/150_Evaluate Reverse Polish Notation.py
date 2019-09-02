from typing import List

from pip._vendor.msgpack.fallback import xrange


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        s=['+','-','*','/']
        stack=[]
        for i  in xrange(len(tokens)):
            if tokens[i] not in s:
                stack.append(tokens[i])
            else:
                b=int(stack.pop())
                a=int(stack.pop())
                ans=0
                if(tokens[i]=='+'):
                    ans=a+b;
                elif(tokens[i]=='-'):
                    ans=a-b
                elif(tokens[i]=='*'):
                    ans=a*b
                elif(tokens[i]=='/'):
                    ans=a/b
                stack.append(str(int(ans)))

        return int(stack.pop())
