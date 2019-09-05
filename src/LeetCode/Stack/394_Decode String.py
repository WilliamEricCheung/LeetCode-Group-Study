class Solution:
    def decodeString(self, s: str) -> str:
        n = len(s)
        num = [str(i) for i in range(10)]
        i = 0
        temp = 0
        queue = []
        num_queue = []

        while (i < n):

            if s[i] in num:
                num_queue.append(s[i])
                i += 1
            elif s[i] == '[':
                queue.append('[')
                num_queue.append('#')
                i += 1
            elif s[i] == ']':
                num_queue.pop()
                nums = ''
                while (num_queue):
                    num_temp = num_queue.pop()
                    if (num_temp == '#'):
                        num_queue.append('#')
                        break

                    nums += str(num_temp)

                print(nums)
                s_temp = []
                while (queue):
                    t_top = queue.pop()
                    if (t_top != '['):
                        s_temp.insert(0, t_top)
                    else:
                        break

                for j in range(int(nums[::-1])):
                    queue += s_temp
                i += 1

            else:
                queue.append(s[i])
                i += 1
        return "".join(queue)



