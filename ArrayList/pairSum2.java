package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

//Search for a pair in Sorted rotated array that adds up to target
public class pairSum2 {

    //2 Pointer - O(n)
    public static void pairSum(ArrayList<Integer> list, int target){
        
        //find pivot
        int pivot = 0;
        for(int i = 0 ; i<list.size()-1 ; i++){
            if(list.get(i)>list.get(i+1)){
                pivot=i+1;
            }
        }
        //assing starting index
        int start = pivot;
        //find size of arraylist
        int n = list.size();
        //assing ending index
        int end = pivot-1;

        while (start!=end) {

            if(list.get(start)+list.get(end)==target){
                System.out.println("Pair that adds up to target is " + list.get(start) + " , " + list.get(end));    
            }

            
            if((list.get(start)+list.get(end))<target){
                //rotation & changing of starting index according to the conditon and the fact that the array is rotated sorted
                start=(start+1)%n;
            }else{
                //similarly for ending index
                end=(n+end-1)%n;
            }
        }
    }
    public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 6, 1, 2, 3));
        int target = 7;


        pairSum(list, target);
    }
}
