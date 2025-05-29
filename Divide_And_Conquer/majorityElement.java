package Divide_And_Conquer;

public class majorityElement {

    public static int majority(int arr[] , int si , int ei){

        if(si==ei){
            return arr[si];
        }

        int mid = (si+ei)/2;
        int left = majority(arr, si, mid); //majority of left side
        int right = majority(arr, mid+1, ei);//majority of right side

        //from here we find majority of the PARENT SUBARRAY 
        //majority element of their own subarray is same , hence majority for parent is also same
        if(left == right){
            return left;
        }else{
            //majority of their own is differnt 
            //we gotta count how many times the majority appears for the SAME PARENT ELEMENT and return the highest count's element
            int leftCount = 0 ; 
            int rightCount = 0;
            for(int i = si ; i<arr.length ; i++){
                if(arr[i]==left){
                    leftCount++;
                }
                if(arr[i]==right){
                    rightCount++;
                }
            }
            if(leftCount>rightCount){
                return left;
            }else{
                return right;
            }
        }


    }
    public static void main(String[] args) {
        int arr[]={2,1,1,3,5,4,3,2,2,2,2};
        System.out.println(majority(arr, 0, arr.length-1));
        
    }   
}
