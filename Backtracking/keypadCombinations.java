package Backtracking;

import java.util.ArrayList;

public class keypadCombinations {

    public static ArrayList<String> keypad(String digit){ 
        ArrayList<String> result = new ArrayList<>();
        if(digit==null || digit.length()==0){
            return result;
        }
        // create an array of string to map each digit to its corresponding characters according to index
         String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        //function call to find all the valid combinations using backtracking
        backtrack("", digit, result, 0, mapping);
        //returning all the valid combinations provided by the backtracking function by an ArrayList
        return result;
    }

    //curr -> represents one valid combination for the given digit
    //index-> used to iterate over the digits and find the appropriate letters for that digit in mapping array , also used to find out when to stop
    //result -> stores all the valid combinations

    public static void backtrack(String current , String digit , ArrayList<String> result , int index , String mapping[] ){
        //base case
        //combination length must be equal to the digit length as we get to pick one each time for one number
        //if index reaches digit length thus its a valid combination
        if(index==digit.length()){
            result.add(current);
            return;
        }

        //finding out and storing all the valid letters for the current digit at index 
        String letters = mapping[digit.charAt(index)-'0']; //converts '2'-> 2


        for(int i = 0 ; i<letters.length() ; i++){
            char ch = letters.charAt(i);
            backtrack(current+ch, digit, result, index+1, mapping);
        }
    }

    public static void main(String[] args) {
                String digit = "23";
                ArrayList<String> result = keypad(digit);
                System.out.println(result);

        
    }
}
