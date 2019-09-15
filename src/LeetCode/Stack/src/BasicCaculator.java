import java.util.Stack;

public class BasicCaculator {
    public int caculator(String s){
        Stack<Integer> stack = new Stack<Integer>();
        int number = 0;
        int sign = 1;
        int result = 0;

        for(int i = 0; i <s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                number = number*10 + (int)(c - '0');
            }

            if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }

            if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }

            if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }

            if(c == ')'){
                result += number * sign;
                number = 0;
                result *= stack.pop();
                result +=stack.pop();
            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
}
