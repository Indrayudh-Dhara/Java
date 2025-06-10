package Stack;
import java.util.Stack;

public class reverseStr {
    //my method
    public static void reverseString(StringBuilder str){
        Stack<Character> s = new Stack<>();
        int idx=0;
        while(str.length()>0){
            s.push(str.charAt(idx));
            str.deleteCharAt(idx);
        
        }
        while(!s.isEmpty()){
            str.append(s.pop());
        }
        System.out.println(str);
    }

    //teacher's method
     public static void reverseStringMentor(String str){
        Stack<Character> s = new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
           idx++;
        
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        str = result.toString(); // as stringbuilder and string is of different Type
        System.out.println(str);
    }

    public static void main(String[] args) {
        reverseString(new StringBuilder("HelloWorld"));
    }
}
