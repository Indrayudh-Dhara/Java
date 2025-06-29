package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class frequentNumber {

    public static void code(ArrayList<Integer> freq , ArrayList<Integer> nums , int key){
    
        for(int i = 0 ; i<nums.size() ; i++){
            if(nums.get(i)==key && i<nums.size()-1){
                freq.set(nums.get(i+1), freq.get(nums.get(i+1))+1);
            }
        }
        int max = Integer.MIN_VALUE;
        int index = 0 ; 
        for(int i = 0 ; i<freq.size() ; i++){
            if(freq.get(i)>max){
                max=freq.get(i);
                index = i;
            }
        }
        System.out.println(index);

    }
    public static void main(String[] args) {
        ArrayList<Integer> freq = new ArrayList<>(Collections.nCopies(101, 0)); // an array can be used instead to automatically initialize by 0 
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2,2,2,3));
        code(freq,nums,2);
    }
}
