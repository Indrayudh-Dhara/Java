package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class lonelyNumber {

    public static void iterateThrough(ArrayList<Integer> list, ArrayList<Integer> solution){
        // stand on each element for the array and check if its lonely or not
        for(int i = 0  ; i<list.size() ; i++){
            int currElement = list.get(i);
            for(int j = i+1 ;j<list.size() ; j++ ){
                if(list.get(j)==currElement || list.get(j)==currElement+1 || list.get(j)==currElement-1){
                    solution.add(list.get(j));
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(10 , 6 , 5 ,8));

        
    }
}
