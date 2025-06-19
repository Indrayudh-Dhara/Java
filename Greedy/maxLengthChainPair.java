package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class maxLengthChainPair {

    public static void maxLength(int pair[][]){
        Arrays.sort(pair, Comparator.comparingDouble(o -> o[1])); //sort in ascending based on the ending number
        // no we gotta check if the starting of now is greater than the ending of previous 
        //we take the first in the chain by hard coding
        int ans = 0 ;
        int lastEnd=pair[0][1]; //storing the end of the first pair as we select the first pair by hard coding
        ans++;
        for(int i = 1 ; i<pair.length;i++){ //start loop from next pair
            if(pair[i][0]>=lastEnd){
                
                lastEnd=pair[i][1];
                ans++;
            }
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        int pair[][]={{5,24},{39,40},{5,28},{27,40},{50,90}};
        maxLength(pair);
    }
}
