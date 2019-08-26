class Solution:
    def addBinary(self, a: str, b: str) -> str:
        lenb = len(b)
        lena = len(a)
        if (lena > lenb):
            c = a;
            max = len(a)
        else:
            c = b;
            max = len(b)
        c1 = list(c)

        for i in range(max):
            if (i <= lena - 1 and i <= lenb - 1):
                sum = int(a[lena - i - 1]) + int(b[lenb - i - 1])

                c1[max - i - 1] = str(sum)

            elif (i > lena - 1 and i <= lenb - 1):
                c1[max - i - 1] = b[lenb - i - 1]
            else:
                c1[max - i - 1] = a[lena - i - 1]
            print(c1)
        for i in range(max):
            if (int(c1[max - 1 - i]) >= 2):

                c1[max - 1 - i] = str(int(c1[max - 1 - i]) % 2)
                if (i != max - 1):
                    c1[max - i - 2] = str(int(c1[max - i - 2]) + 1)
                else:

                    c = ''.join(c1)
                    c = "1" + c

            elif (i == max - 1):
                c = ''.join(c1)
        return c