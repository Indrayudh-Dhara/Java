package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Set;

public class majorityElement {

    public static void majorityEl(int arr[]){
         HashMap<Integer, Integer> majorityEl = new HashMap<>();
            int n = arr.length;
        for(int i = 0 ; i<arr.length ; i++){
            if(majorityEl.containsKey(arr[i])){
                majorityEl.put(arr[i], majorityEl.get(arr[i])+1);
            }
            else{
                majorityEl.put(arr[i], 1);
            }
        }
        Set<Integer> keys = majorityEl.keySet();
        ArrayList<Integer> majorityElements = new ArrayList<>();
        for(int key : keys){
            if(majorityEl.get(key)>(n/3)){
                majorityElements.add(key);
            }
        }

        System.out.println(majorityElements);
    }
        
    
    public static void main(String[] args) {
       
        int arr[] ={1,2};
        majorityEl(arr);
     
}
}
