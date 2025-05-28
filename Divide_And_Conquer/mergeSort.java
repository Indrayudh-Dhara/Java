package Divide_And_Conquer;

public class mergeSort{

    public static void mergeSortCode(int arr[] , int si , int ei){
        //base case
        if(si>=ei){
            return;
        }

        int mid=(si+ei)/2;

        mergeSortCode(arr, si, mid);
        mergeSortCode(arr, mid+1, ei);
        merge(arr ,  si ,  ei ,  mid);


    }

    public static void merge(int arr[], int si , int ei , int mid){
        //same size array as current 
        int temp[] = new int[ei-si+1];
        // i , j  as we wont change the original si and mid ( as wee need them while copying into original array)
        int i = si;
        int j = mid+1;
        int k=0;
        //sort from the left half and right half (ascending) , and put them one by one in temp
        
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        //left overs ( if one of the right/left part gets all added into temp the loop breaks thus , there can be left overs in other side )

        //left leftovers
        while(i<=mid){
           
                temp[k++]=arr[i++];
               
            
        }
        //right leftovers
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(i=si , k=0 ; k<temp.length ; i++,k++){
            arr[i]=temp[k];
        }
    }

    public static void printArr(int arr[]){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }



    public static void main(String[] args) {
        int arr[]={3,4,6,8,3,9,6,3,7};
        mergeSortCode(arr, 0, arr.length-1);
        printArr(arr);
        
    }
}

