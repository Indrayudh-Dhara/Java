import java.util.Stack;

public class duplicateParenthesis {

    //my method (using the opening)
    public static boolean findDuplicates(String expression){
        Stack<Character> s = new Stack<>();
    
        for(int i = 0 ; i < expression.length() ; i++){
           char currChar = expression.charAt(i);
           if(currChar!=')'){
            s.push(currChar);
           }else{
            //duplicate case as nothing in between two parenthesis , stack top shouldnot have a opening bracket at the first time
            if(s.peek()=='('){
                return true;
            }
            while(s.peek()!='('){
                s.pop();
            }
            s.pop();
            
           }
        }
        return false;
    }

    //teachers method (using the closing)
    public static boolean findDuplicatesMentor(String expression){
        Stack<Character> s = new Stack<>();
        
        for(int i = 0  ;  i<expression.length() ; i++){
            char ch = expression.charAt(i);
            if(ch ==')'){
                int count=0; //to track if there is anything between a bracket pair
                while (s.pop()!='(') {
                    count++;
                }
                if(count<1){
                    return true; //duplicates no expression in between directly the opening bracket
                }
            }else{ //current expression is not closing thus push in stack
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        System.out.println(findDuplicates("((a+(b))+(c+d))")); //false
        System.out.println(findDuplicates("(((a)+(b))+c+d)")); // false
        System.out.println(findDuplicates("((a+b)+(c+d))"));   // false
        System.out.println(findDuplicates("(((a+b))+c)"));     // true
        System.out.println(findDuplicates("(a+(b))"));         // false
        System.out.println(findDuplicates("((a+b))"));         // true
        System.out.println(findDuplicates("(a)"));             // false
        System.out.println(findDuplicates("()"));              // true

    }
}
