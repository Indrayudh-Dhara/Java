package Greedy;

import java.util.ArrayList;

public class lexicoSmallest {

    public static void code(int n , int k){
        //n - length of string to be made
        //k - sum of string to be made
        //lexicographically smallest thus we need strings more towards the left ie(closer to a or a itself and farther from z )

        //we start with a string entirely with a 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }

        int remaining = k-n ; //where n is the current total sum for all a's
        int index = n-1; //start from last

        while(remaining>0 &&index>=0){
            int add = Math.min(25,remaining); //max possible add 25 ('z')->26-a(as a is removed to add z) , if remaning sum is less that 25 we add the according character
            sb.setCharAt(index , (char)('a'+add));//changing char at index (starting from end then proceeding backwards)
            remaining-=add;//remaning sum changes
            index--;
        }
        System.out.println(sb);

    }
    public static void main(String[] args) {
        code(5, 42);
        // System.out.println((char)('a'+24));
    }
}
