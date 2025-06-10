package Stack;
import java.util.Stack;

public class nextGreater {

    public static void main(String[] args) {
        
        int arr[]={6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];
        //start from the end 
        for(int i  = arr.length-1 ; i>=0 ; i--){
            //till stack is empty and current element we are working with is greater than the elements(right) present in the indexs which are stored in the stacks 
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            //at this point the stack is either empty or the top of stack has index which has the element greater than the current element we are working with, thus its the nextgreater
            if(s.isEmpty()){
                //nothing is greater 
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=arr[s.peek()];
            }
            //push the current index we are working with for future calculation
            s.push(i);
        }

        for(int i= 0 ; i<nextGreater.length ; i++ ){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();

        //variations of this logic code

        //next Greater Right
        //next Greater Left
        //next Smaller Right
        //next Smaller Left

    }
}
