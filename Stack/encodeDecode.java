import java.util.Stack;

public class encodeDecode {

    //my version without peeking only logic
    public static void code(String str){
        Stack<Character> s = new Stack<>();
        
        StringBuilder substring = new StringBuilder("");
        for(int i = 0 ; i<str.length() ; i++){
            substring= new StringBuilder("");
            //push everything thats not a ']' , when it is solve for the current bracket
            if(str.charAt(i)!=']'){
                s.push(str.charAt(i));
            }
            else{
                //remove until the bracket pairs are met
                while (s.peek()!='[') {
                    substring.append(s.pop());    //create your substring to be repeated (Note - substring contains the chars in reverse order)         
            }
            s.pop();//pop out the '[' 
            int count = s.pop()-'0'; //pop out the stored number in int form 

            while(count!=0){
                int j = substring.length()-1; //calculate substring length at every level
                
                while(j!=-1){ //push every chars of substring
                    s.push(substring.charAt(j)); //pushing in reverse order as well thus its now in original order
                    j--;
                }
                count--;  //repeatation process     
            }
        }
    }
    System.out.println(s);
    }
    //chatgpt(not evaluated by me | just for reference)
    public static void decode(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If digit, build the full number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            // Push number and open bracket
            else if (ch == '[') {
                stack.push(String.valueOf(num));
                stack.push("[");
                num = 0;
            }
            // If closing bracket, build substring
            else if (ch == ']') {
                StringBuilder temp = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    temp.insert(0, stack.pop());  // build in correct order
                }
                stack.pop(); // remove '['
                int repeatCount = Integer.parseInt(stack.pop());
                String repeated = temp.toString().repeat(repeatCount);
                stack.push(repeated);
            }
            // If normal character, just push
            else {
                stack.push(String.valueOf(ch));
            }
        }

        // Final result
        StringBuilder result = new StringBuilder();
        for (String s : stack) {
            result.append(s);
        }

        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        code("3[b2[v]]");
       
    }
}
