
import java.util.ArrayList;

//implementation of Stack using ArrayList

public class implementationAL {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }

        //push [add from top(last)]
        public static void push(int data){
            list.add(data);

        }

        //pop [remove from top(last)]
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        //peek [get from top(last)]
        public static int peek(){
            return list.get(list.size()-1);
        }
    }

    public static void main(String[] args) {
        //make an object
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        
    }
}
