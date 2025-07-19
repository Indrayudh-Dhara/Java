package Arrays;

import Hashing.largestSubArr;

public class maximumSubArr {

    public static void usingPrefix(int arr[]){
        int prefix[] = new int[arr.length];
        prefix[0]=arr[0];
        int maxSum= 0 ;
        int sum = prefix[0];
        for(int i = 1 ; i<prefix.length ; i++){
            sum+=arr[i];
            prefix[i]=sum;
        }

        for(int i= 0 ;i<prefix.length ; i++){
            sum = 0 ;
            for(int j = i ; j<prefix.length ; j++){
                sum = i==0? prefix[j] :  prefix[j]-prefix[i-1]; //if confused , do a rough work

                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }

    public static void usingKadence(int arr[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0 ;

        for(int i = 0 ; i< arr.length ; i++){
            cs = cs+arr[i];
            if(cs<0){
                cs=0;
            }
            ms = Math.max(ms, cs);
        }

        System.out.println(ms);
    }
    public static void main(String[] args) {
        int arr[] = {1,-2,6,-1,3};
            usingPrefix(arr);
            usingKadence(arr);
    }
}
