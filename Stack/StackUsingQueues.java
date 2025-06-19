import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    //POP(O(n)) Type

    static class Stack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
                
            }else{
                q2.add(data);
             
            }
            
        }

        public int pop(){
            //check if the stack is empty or not using its own isempty method that we created
            if(isEmpty()){
                return -1;
            }
            int top=-1;
            //one of the queue is empty so we need to check which one is not and remove it from that
            if(!q1.isEmpty()){
                  while(!q1.isEmpty()){
                 top = q1.remove();
                 //in this way only the last element doest get transfereed to another queue , thats the only thing to be removed
                if(q1.isEmpty()){
                    break;
                }
                q2.add(top);
            }
            }else{
                while(!q2.isEmpty()){
                 top = q2.remove();
                if(q2.isEmpty()){
                    break;
                }  
                //for elements which are not the last we need to shift it to another queue
                q1.add(top);      
            }
        }
          
    return top;

        }

        public int peek(){
             if(isEmpty()){
                return -1;
            }
            int top=-1;
            //one of the queue is empty so we need to check which one is not and remove it from that
            if(!q1.isEmpty()){
                  while(!q1.isEmpty()){
                 top = q1.remove();
                 //in this way only the last element doest get transfereed to another queue , thats the only thing to be removed

                 //for peek we dont need to remove the last element , so we push everything to anothr queue and top obviously always has the last element in it anyways
                // if(q1.isEmpty()){
                //     break;
                // }
                q2.add(top);
            }
            }else{
                while(!q2.isEmpty()){
                 top = q2.remove();
                // if(q2.isEmpty()){
                //     break;
                // }  
                //for elements which are not the last we need to shift it to another queue
                q1.add(top);      
            }
        }
          
    return top;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        

        //3->2->1  LIFO
    }
}
