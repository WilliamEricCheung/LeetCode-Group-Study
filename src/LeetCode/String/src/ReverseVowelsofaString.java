import java.util.HashSet;

public class ReverseVowelsofaString {
    void reverse(char a, char b){
        char temp = a;
        a = b;
        b = temp;
    }
   private HashSet<Character> vowels = new HashSet<>(){{
       add('a');
       add('A');
       add('e');
       add('E');
       add('i');
       add('I');
       add('o');
       add('O');
       add('u');
       add('U');
   }};

   public String rvs(String s){
       int i = 0;
       int j = s.length() - 1;
       char c[] = s.toCharArray();
       while( i < j ){
           while(i < j && ! vowels.contains(c[j])) j--;
           while(i < j && ! vowels.contains(c[i])) i++;
           if(c[i] != c[j] ) reverse(c[i], c[j]);
       }
       return c.toString();
   }

}
