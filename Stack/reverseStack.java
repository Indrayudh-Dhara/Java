package Stack;

import java.util.Stack;

public class reverseStack {

    public static void pushAtBottom(Stack<Integer> s , int data){
        //base case
        if(s.isEmpty()){
            s.push(data);
            return ;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }


    public static void reverseStackCode(Stack<Integer> s){
    //base case for this recursion , when s is empty 
        if(s.isEmpty()){
            return;
        }
        //storing the top to push it to the bottom one by one when backtracking
        int top = s.pop();
        //recusively calling for the stack without the current top
        reverseStackCode(s);
        //pushing the top at the bottom while backtracking calls using the pushatbottom function
        pushAtBottom(s, top);

    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        reverseStackCode(s);

          while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        
    }
}
