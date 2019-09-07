public class PlusOne {
    public int[] plusone(int[] digit){
        for(int i = digit.length -1; i >= 0; i--){
            if(digit[i] < 9){
                digit[i]++;
                return digit;
            }
            digit[i] = 0;
        }

        int[] Newnumber = new int[digit.length + 1];
        Newnumber[0] = 1;
        return Newnumber;
    }
}
