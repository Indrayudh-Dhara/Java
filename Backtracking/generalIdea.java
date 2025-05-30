package Backtracking;

public class generalIdea {

    public static void general(int arr[] , int i , int val){
        //base case
        if(i>=arr.length){
            printArr(arr);
            return;
        }


        //recursion
        arr[i]=val;
        //assign values recursively while calling next
        general(arr, i+1, val+1);
        //after all calls are done and the calls starts retracking back(backtracking) (starts returning)
        arr[i]=val-2;
    }

    public static void printArr(int arr[]){
        for(int i =0 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        general(arr, 0, 1);
        printArr(arr);
    }
}
