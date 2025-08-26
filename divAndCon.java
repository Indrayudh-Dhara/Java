import java.util.*;
public class divAndCon {



    public static void mergeSort(int arr[], int si , int ei){ 
        // arr = {6, 3, 9, 5, 2, 8}       call stack 
//         mergeSort(0, 5)
// ├── mergeSort(0, 2)
// │   ├── mergeSort(0, 1)
// │   │   ├── mergeSort(0, 0)
// │   │   └── mergeSort(1, 1)
// │   │   └── merge(0,1)
// │   └── mergeSort(2, 2)
// │   └── merge(0,2)
// └── mergeSort(3, 5)
//     ├── mergeSort(3, 4)
//     │   ├── mergeSort(3, 3)
//     │   └── mergeSort(4, 4)
//     │   └── merge(3,4)
//     └── mergeSort(5, 5)
//     └── merge(3,5)
// └── merge(0,5)


        if(si>=ei){
            return ;
        }
        //kaam
        int mid = si+(ei-si)/2;  
        //left
        mergeSort(arr, si, mid); 
        //right
        mergeSort(arr, mid+1, ei);
        merge(arr,si,ei,mid);
           
    }

    public static void merge(int arr[], int si , int ei , int mid){
        int temp[] = new int[ei-si+1];   
        int i = si; 
        int j = mid+1;  
        int k = 0 ; 
        while(i<=mid && j<=ei){   
            if(arr[i]<arr[j]){  
                temp[k] = arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        //left leftovers
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //rightleftovers
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for( k = 0 , i=si ; k <temp.length ; i++, k++){
            arr[i]=temp[k];
        }

    }

    public static void quickSort(int arr[], int si , int ei){
        if(si>=ei){
            return;
        }

        
        int pIdx = partition(arr,  si ,  ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }

    public static int partition(int arr[], int si , int ei){
        int pivot = arr[ei];
        int i = si-1;
        for(int j = si ; j<ei ; j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
        arr[j]=arr[i];
        arr[i] = temp;
            }
        }
        i++;
        
        arr[ei]=arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void mergeSortStr(String arr[] , int si , int ei){    //divide left -> divide right ->base case-> merge
        //base case
        if(si>=ei){
            return;
        }
        //work
        int mid = (si+ei)/2;
        mergeSortStr(arr, si, mid);
        mergeSortStr(arr, mid+1, ei);
        mergeStr(arr, si, ei , mid);
    }

    public static void mergeStr(String arr[] ,int si , int ei , int mid ){ //arr , 0, 0 
        String temp[] = new String[ei-si+1];
        int i=si;
        int j=mid+1; 
        int k =0;

        while(i<=mid && j<=ei){
            if((arr[i].compareTo(arr[j]))<0){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
                temp[k++]=arr[i++];
         }
        while(j<=ei){
           
                temp[k++]=arr[j++];
            
        }

        for(i=si ,k=0 ; i<temp.length;i++,k++){
            arr[i]=temp[k];
        }
    }
    public static void printArr(int arr[]){
        for(int i = 0;i<arr.length ; i++){
        System.out.print(arr[i]);
        }
    }
    public static void printArr(String arr[]){
        for(int i = 0;i<arr.length ; i++){
        System.out.print(arr[i]);
        }
    }

    public static void mergeSort(int arr[] , int si  , int ei){
        int mid = (si+ei)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, ei, mid);
    }

    public static void merge(int arr[] , int si , int ei , int mid){
        int temp[] = new int[ei-si+1];//to create the appropriate length of array as of the current broken  small arr part
        while(si<= mid && ei>=mid+1){
            if(arr[si]>)
        }

    }




    public static int majorityELement(int arr[] , int si , int ei){
        //base case
        if(si==ei){
            return arr[si];
        }
        int mid = (si+ei)/2;
        int leftSide = majorityELement(arr, si, mid); //majority element of left part (recursively)
        int rightSide = majorityELement(arr, mid+1, ei); //majority element of right part (recursively)


        //from here the smaller parts which was divided start returning therefore start combining again one after another

            if(leftSide==rightSide){ //majority element for left and right part are some , thus majority element for the parent merge is also same
                return leftSide;
            }else{
                int leftCount = 0;
                int rightCount = 0 ;
                for(int i = 0 ; i<=ei; i++){
                    if(arr[i]==leftSide)leftCount++;
                    if(arr[i]==rightSide)rightCount++;
                }
                return leftCount>rightCount? leftSide:rightSide;
                
            }
        }

    

    public static void main(String[] args) {
        int arr[] = {2,2,3,3,3,3};
        System.out.print(majorityELement(arr, 0, arr.length-1));

        String s = "aabnana";
        Map<Integer,Integer> hs= new HashMap<>();
       Collections.sort(list , Collections.reverseOrder());
        Stack<Character
        
    }
}
