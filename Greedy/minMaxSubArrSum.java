package Greedy;

public class minMaxSubArrSum {
    //minimum possible maximum subarray sum

    public static void code(int arr[]){
        int lowerbound = 0;
        for(int i= 0 ; i<arr.length ; i++){
            if(arr[i]>lowerbound){
                lowerbound=i; //we store the index of the lowerbound
            }
        }
        //now we have the largest element as our lowerbound
        //now we assume that this is the maximum sub array sum possible
        int maxSum= arr[lowerbound]; 
        int sum = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            sum=sum+arr[i];
            if(sum>maxSum){
                
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={6,7,7,8};
        code(arr);
    }
}
