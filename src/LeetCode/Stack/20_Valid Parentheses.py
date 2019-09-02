from pip._vendor.msgpack.fallback import xrange


class Solution:
    def isValid(self, s: str) -> bool:
        if(len(s)==1):
            return False
        q=[]
        for i in xrange (len(s)):
            if(s[i]==']'):
                if not q:
                    return False
                if(q[-1]=='['):
                    q.pop()
                else:
                    return False
            elif (s[i] == ')'):
                if not q:
                    return False
                if (q[-1] == '('):
                    q.pop()
                else:
                    return False
            elif(s[i]=='}'):
                if not q:
                    return False
                if(q[-1]=='{'):
                    q.pop()
                else:
                    return False
            else:
                q.append(s[i])
        if(q):
            return False
        else:
            return True
