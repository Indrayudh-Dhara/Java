package Recursion;

public class checkSorted {


    public static boolean checkSortedArr(int arr[], int si , int ei){
        if(si==ei){
            return true;
        }
        if(arr[si]<=arr[si+1]){
        return checkSortedArr(arr, si+1, ei);
        }else{
            return false;
        }
    }



    public static void main(String[] args) {
          int arr[] = {1,2,3,4,5,6};
    System.out.println(checkSortedArr(arr, 0, arr.length-1));
    }
    
};

