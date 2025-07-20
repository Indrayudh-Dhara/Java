package Hashing;

import java.util.HashMap;

public class largestSubArr {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        int arr[] = {15 , -2 , 2 , -8 , 1 , 7 , 10};
        int sum = 0 ; 
        int length = 0 ;
        for(int i =  0 ;i<arr.length ; i++){
            //case when sum becomes 0 from the beginning
            sum+=arr[i];
            if(sum==0){
                length=i+1;
            }
            if(!hp.containsKey(sum)){
                hp.put(sum , i);
            }else{
                length = Math.max(length, i-hp.get(sum));
            }
        }
        System.out.println(length);

    }
}
