public class AddBinary {
    public String add(String a, String b){
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        for(;i >= 0 || j >= 0; i--, j--){
        int sum = carry;
        if(i >= 0) sum += a.charAt(i) - '0';
        if(j >= 0) sum += b.charAt(j) - '0';
        sb.append(sum % 2);
        carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();


    }

}
