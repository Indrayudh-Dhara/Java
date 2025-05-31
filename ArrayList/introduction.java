package ArrayList;
import java.util.*;
import java.util.stream.Gatherer.Integrator;


public class introduction {

    public static void reverse(ArrayList<Integer> list){

         //print reverse of AL -  O(n)
        for(int i = list.size()-1 ; i>=0;i--){
            System.out.print(list.get(i)+ " ");
        }

    }

    public static void maxValue(ArrayList<Integer> list){

            //print maximum in AL - O(n)
        int max=Integer.MIN_VALUE;
        for(int i = 0  ; i<list.size();i++){
            if(list.get(i)>max){
                max = list.get(i);
            }
        }

        System.out.println(max);

    };

    public static void multiDimensionalList(){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>(); // initialize 2d arraylist
        ArrayList<Integer> list1 = new ArrayList<>(); //create a single normal arraylist
        list1.add(1) ;
         list1.add(2);
        mainList.add(list1) ;// add arraylist li to 2d arraylist mainList
        //similarly add another 1d array list to a 2d arraylist
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        mainList.add(list2);


        //to iterate a 2D arraylist
        for(int i = 0 ; i<mainList.size() ; i++){
            ArrayList<Integer> currList = mainList.get(i);// get current arraylist from the 2d arraylist
            //iteration in the current 1d arraylist
            for(int j = 0 ; j<currList.size() ; j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }


    }

    public static void swap(ArrayList<Integer> list ,int idx1, int idx2){
         
        System.out.println(list);
        int temp = list.get(idx2);
        list.set(idx2, list.get(idx1));
        list.set(idx1, temp);
        System.out.println(list);

    }
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        
       
        multiDimensionalList();
    
    
    }
}
