package Divide_And_Conquer;

public class inversionCount {

    public static void inversion(int arr[]){
        int count = 0;
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = i+1 ; j<arr.length ; j++){
                if(arr[i]>arr[j]){
                    System.out.println("Inversion Subarray" + arr[i] + ", " + arr[j]);
                    count++;
                }
            }
        }
        System.out.println(count);
       
    }

    public static int optimizedInversion(int arr[] , int si , int ei){
        int count=0;
        // base case
        if(si>=ei){
            return 0;
        }

        int mid = (si+ei)/2;

        count+=optimizedInversion(arr, si, mid);
        count+=optimizedInversion(arr, mid+1, ei);
        count+=mergeInversion(arr, si, mid, ei);
        return count;
        
    }

    public static int mergeInversion(int arr[] , int si , int mid , int ei){
        int temp[] = new int[ei - si+1];
       int count=0;
        int k = 0 ; 
        int i = si;
        int j =mid+1;

        while(i<=mid && j<=ei){
           if(arr[i]<=arr[j]){
            temp[k]=arr[i];
            i++;
            
           }else{
            count += mid-i+1;
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

        for(i=si , k=0; k<temp.length ; i++ , k++){
            arr[i]=temp[k];
        }
        return count;


    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        System.out.println(optimizedInversion(arr , 0 , arr.length-1));
        
    }
    
}
