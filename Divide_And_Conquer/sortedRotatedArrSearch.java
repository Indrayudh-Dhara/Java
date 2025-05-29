package Divide_And_Conquer;

public class sortedRotatedArrSearch {

    //finding one integer type code *target 
    public static int sortedRotatedArr(int arr[] , int target ,int si , int ei){
        //base case
        //no element found
        if(si>ei){
            return -1;
        }

        int mid =(si+ei)/2;

        if(arr[mid]==target){
            return mid;
        }


        //seeing whether the mid is on first sorted half
        if(arr[si]<=arr[mid]){
            //searching in that first sorted half if mid lies on it
            //left side
            if(arr[si]<=target && target>=arr[mid]){
        
                return sortedRotatedArr(arr, target, si, mid-1);
            }else{
                //right complete part (not only for the right of this sorted half)
               return  sortedRotatedArr(arr, target, mid+1, ei);
            }
        }
        //seeing whether the mid is on the second sorted half
        else if(arr[mid]<=arr[ei]){
            //searching in that second sorted half if mid lies on it
            //right side
            if(arr[mid]<=target && target<=arr[ei]){
               return sortedRotatedArr(arr, target, mid+1, ei);
            }else{
                //complete left side(not only for the left of this sorted part)
                return sortedRotatedArr(arr, target, si, mid-1);
            }
        }
        return -1;

    }
    
    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2};
        System.err.println(sortedRotatedArr(arr, 7, 0, arr.length-1));
        
    }
}
