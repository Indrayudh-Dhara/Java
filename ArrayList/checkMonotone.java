package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class checkMonotone {

    public static boolean checkMonotoneArr(ArrayList<Integer> list){

        boolean inc = true ; 
        boolean dec = true ;

        for(int i = 0 ; i<list.size()-1 ; i++){
            //check for increasing or not
            if(list.get(i)>list.get(i+1)){
                inc= false;
            }
            //check for decreasing or not 
            if(list.get(i)<list.get(i+1)){
                dec= false;
            }
        }
        //or truth table logic  yes yes yes . no no no , yes no yes, no yes yes
        return inc||dec;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(6,5,4,3,2,1));
        System.out.println(list);
       System.out.println(checkMonotoneArr(list));
        
    }
}
