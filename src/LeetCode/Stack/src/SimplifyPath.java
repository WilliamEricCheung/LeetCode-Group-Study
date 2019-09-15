import java.util.Stack;

public class SimplifyPath {
   public String simple(String path){
      if(path.length() <= 1) return path;
      Stack<String> stack = new Stack<String>();
      String[] each = path.split("/");
      for(String curr : each){
          if(curr.equals("..")){
              if(!stack.empty()) stack.pop();
          }
          else if (! curr.equals(".") && ! curr.isEmpty()) stack.push(curr);
      }

      String result = " ";
      if(stack.empty()) return "/";
      while(!stack.empty()){
          String newPop = stack.pop();
          result = "/" + newPop + result;

      }
      return result;
   }
}
