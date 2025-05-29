package Divide_And_Conquer;

public class quickSort {
    
    public static void quickSortCode(int arr[] , int si , int ei){
        //base case
        if(si>=ei){
            return;
        }
        
        int pIdx = parition(arr, si, ei);
        quickSortCode(arr, si, pIdx-1);
        quickSortCode(arr, pIdx+1, ei);

    }

    public static int parition(int arr[] , int si , int ei){
        int pivot = arr[ei];
        //make space for elements smaller than pivot
        int i=si;
        //looping from si to ending -1 (excluding the pivot)
        for( int j = si ; j<=ei-1 ; j++){
            if(arr[j]<pivot){
                //swap with i and j(smaller elements than pivot)
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
        //no elements to be sorted before the pivot so the final i needs to have pivot in its place so swap i with pivot
        int temp = arr[i];
         arr[i]=arr[ei];
         arr[ei]=temp;
        //return the correct pivot index to call the left and right halfs based on that
        return i;
        
    }

    
    public static void printArr(int arr[]){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,7,9,5,3,9,1};
        quickSortCode(arr, 0, arr.length-1);
        printArr(arr);
    }
}
