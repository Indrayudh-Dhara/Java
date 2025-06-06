package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class lonelyNumber {

    public static void iterateThrough(ArrayList<Integer> list, ArrayList<Integer> solution){
        boolean lonely=true;
        // stand on each element for the array and check if its lonely or not
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
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(1,3,5,3));
        ArrayList<Integer> solution = new ArrayList<>();
        iterateThrough(list, solution);
        
    }
}

//sit on the element remove the elemnt from the original array , search the array find out if duplicates, plus one minys one exists or not , after its done, add the element back search for the enxt noe
