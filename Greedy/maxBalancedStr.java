package Greedy;

import java.util.Arrays;

public class maxBalancedStr {

        // **Maximum Balanced String Partitions**

        // We have a balanced string `str` of size `N` with an equal number of `L` and `R`. The task is to find a maximum number `X` such that the given string can be partitioned into `X` balanced substrings.
        // A string is called balanced if the number of `L`s in the string equals the number of `R`s.

        // **Input:** `"LRRRRLLRLLRL"`
        // **Output:** `3`

    public static void code(String str){
        

        int balance = 0 ; 
        int count = 0 ;

        for(int i = 0 ; i<str.length() ; i++){
            char ch = str.charAt(i); //we take the current character
            if(ch=='L'){ //now for L we increase balance
                balance++;
            }else{
                balance--;//for R we decrease
            }

            if(balance ==0){ //balance 0 means L and R equal and also this is hard coded , (i.e as soon as we get a equal pair of l and r we break the string)
                            //as we need the maximum no of partitions (GREEDY)
                count++;
            }
        }
        System.out.println(count);  


    }


    public static void main(String[] args) {
        String str ="LRRRRLLRLLRL";
        code(str);
    }
}
