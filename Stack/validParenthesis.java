import java.util.Stack;

public class validParenthesis {

    public static boolean validParenthesisCheck(String str){
        Stack<Character> s = new Stack<>();
        //  if(str.charAt(0)==')' || str.charAt(0)==']' || str.charAt(0)=='}' || str.charAt(str.length()-1) =='(' || str.charAt(str.length()-1) =='{' ||str.charAt(str.length()-1) =='['){
        //         return false;
        //     }

        //check for each character in string
        for(int i = 0 ;i<str.length() ; i++){
            //for opening brackets push into stack  (LIFO)
            if(str.charAt(i)=='{' || str.charAt(i)=='[' || str.charAt(i)=='('){
                s.push(str.charAt(i));
            }else{
                //closing bracket

                //Stack is enmpty INSIDE loop (ie String has not ended ) thus there is a closing bracket without a opening
                if(!s.isEmpty()){
                    return false;
                }
                //now check for pairs (Valid or not)
                //current character we are working with
                char current=str.charAt(i);
                //top of stack (which should be the closing of the current opening)
                char top = s.peek();
                if ((current == ')' && top == '(') || (current == ']' && top == '[') ||  (current == '}' && top == '{')) {
                     s.pop(); // it's a match (valid pair), remove the opening bracket and go for the next pair  
                }else{
                    //invalid pair
                    return false;
                }
                }
               
            }
                
                
            
        //at the END after traversing through the entire str stack should be empty , if not its not valid 
        return s.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println(validParenthesisCheck("{}[]("));
    }
}
