package ArrayList;

import java.util.ArrayList;

public class pairSum {

    //brute force O(n^2)
    public static void sum(ArrayList<Integer> list , int targetSum){

        
        
        for(int i = 0 ; i<list.size() ; i++){
            for(int j = i ; j<list.size() ; j++){
                if((list.get(i)+list.get(j)) == targetSum){
                    System.out.println("Pairs that make target sum is : " + list.get(i) + " , " + list.get(j)  );
                    
                }
            }
        }
    }

    //2pointer -O(n)
    public static void optimizedSum(ArrayList<Integer> list , int targetSum){
        int i = 0 ; 
        int j = list.size()-1;
        while(i<j){
            int sum = list.get(i)+list.get(j);
           if(sum == targetSum){
                    System.out.println("Pairs that make target sum is : " + list.get(i) + " , " + list.get(j)  );   
                    //to avoid duplicates
                    i++;
                    j--; 
                }


            if(sum>targetSum){
                j--;
            }else{
                i++;
            }
        }
    }
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        sum(list, 5);
        optimizedSum(list, 5);
        
    }
}
