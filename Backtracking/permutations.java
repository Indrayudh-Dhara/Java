package Backtracking;

public class permutations {

    public static void permutationsCode(String str , String subStr){
        //base case
        //when all the elements are added therefore the str has no elements left in it as we remove everytime we add a character from str
        if(str.length()==0){
            //each permutation being printed
            System.out.println(subStr);
            return;
        }

        //for loop to START the substring with all element in the str one by one 
        for(int i = 0 ; i<str.length();i++){
            //getting the current character
            char n = str.charAt(i);
            //basically removing the current character which is to be added and used in the substring , to not have duplicates
            String newStr = str.substring(0, i)+str.substring(i+1);
            //recursion with the newStr = removed curr char from str and substr with added current character
            permutationsCode(newStr, subStr+n);
        }
    }
    public static void main(String[] args) {
        permutationsCode("abc", "");
    }
}
