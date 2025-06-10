package Stack;
import java.util.Stack;

//in O(n) using Stacks 
public class stockSpan {

    public static void stockSpanCode(int stocks[] , int span[]){
        //use this stack to store the index of previous highs for every current element we are trying to find the span of
        Stack<Integer> s = new Stack<>();
        //always as first element of stocks
        span[0]=1;
        //thus its the previous high of the next element
        s.push(0);
        
        //loop to operate for every element in the stocks arrays (THE STOCKS VALUES) one by one
        for(int i = 1 ; i<stocks.length ; i++){
            //find out the current element
            int currElement = stocks[i];
                while(!s.isEmpty() && currElement>stocks[s.peek()]){ //as long as is not empty and currelement is greater than the element present at previousHighindex in stocks array stored in the stack
                    s.pop();//keep popping as current element is greater this idx is not the previous high anymore in the stack
            }
            //here either the stack is empty or the idx present at the stack is the previousHigh index (ie the element of that index in stocks is higher than the current element we are working with)
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int previousHigh = s.peek(); // find out the previous high index
                span[i]= i - previousHigh ; //formula for span calculation of that particular element
            }

            s.push(i); // push the  current index for the calculation for the next stock , if its not the prev index it will get removed by our logic
        }

       
    }


    public static void main(String[] args) {
        int stocks[] = { 100 , 80, 60 , 70, 60 , 85 , 100};
        int span[] = new int[stocks.length];

        stockSpanCode(stocks , span);
    }
}
