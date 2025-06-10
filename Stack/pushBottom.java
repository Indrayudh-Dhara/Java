package Stack;
import java.util.Stack;

public class pushBottom {

    public static void pushAtBottom(Stack<Integer> s , int data ){
        //base case where stack is empty recursively and we push data (this it gets pushed in the bottom)
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        //we store the stack datas in this top for the recursion's implicit stack for putting em back in future backtracking
        int top = s.pop();
        //calling for the stack without the previous top
        pushAtBottom(s, data);
        //back tracking step when we put the tops we removed back in after data is inserted in the bottom in the base case
        s.push(top);
    }
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        
    }
}
