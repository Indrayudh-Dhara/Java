package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class lonelyNumber {

    public static void iterateThrough(ArrayList<Integer> list, ArrayList<Integer> solution){
        boolean lonely=true;
        // stand on each element for the arraylist and check if its lonely or not
        for(int i = 0  ; i<list.size() ; i++){
            int currElement = list.get(i);
            list.remove(i);
            for(int j = 0 ;j<list.size() ; j++ ){
                if(list.get(j)==currElement || list.get(j)==currElement+1 || list.get(j)==currElement-1){
                    lonely=false;;
                }
            }
            if(lonely==true){
                solution.add(currElement);
            }
            lonely=true;
            list.add(i, currElement);
        }
        System.out.println(solution);
    }

    public static void optimizedCode(ArrayList<Integer> list, ArrayList<Integer> solution){

     
        Collections.sort(list); //sorts in ascending order

        for(int i = 0 ; i<list.size();i++){
            int curr= list.get(i);
            boolean lonely=true;
        
          //if its not the first element
          if(i>0 && Math.abs(list.get(i-1)-curr)<=1){ //0 when previous is equal and 1 when previous is +-1
            lonely=false;
          }

          //if its not the last element
          if(i<list.size()-1 && Math.abs(list.get(i+1)-curr)<=1){
            lonely=false;
          }


          //what happens by this NOT the first and last element approach is 
          //1. For the first element it automactially just check the next one
          //2.For the last element it automactially just checks the previous one
          //3.For middle elements it check both the sides


            if(lonely){
                solution.add(curr);
            }
            

        }

        System.out.println(solution);

    }
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(1,3,5,3));
        ArrayList<Integer> solution = new ArrayList<>();
        iterateThrough(list, solution);
        optimizedCode(list, solution);
        
    }
}

//sit on the element remove the elemnt from the original array , search the array find out if duplicates, plus one minys one exists or not , after its done, add the element back search for the enxt noe
