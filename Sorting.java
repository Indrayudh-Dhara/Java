public class Sorting {
    public static void bubbleSort(int arr[]){
        for(int i = 0 ; i <arr.length-1; i++){
            for(int j= 0 ;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }   
     }
     
     public static void selectionSort(int arr[]){

        
        for(int i =0;i<=arr.length;i++){
            int smallest = Integer.MAX_VALUE;
            for(int j=i+1;j<=arr.length;j++){
                if(arr[j]<smallest){
                    smallest=arr[j];
                }
            }
            arr[i]=smallest;
        }
     }
     public static void insertionSort(int arr[]){
        for(int i = 1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;

           
        }
     }

     public static void countingSort(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
           max=Math.max(max,arr[i]);
                }
        int arrFreq[]=new int[max+1];
        for(int i=0;i<arrFreq.length;i++){
            arrFreq[arr[i]]++;
        }
        int j =0;
        for(int i =0 ;i<arrFreq.length;i++){
            while(arrFreq[i]>0){
                arr[j]=i;
                j++;
                arrFreq[i]--;
            }
        }
     }
    public static void main(String[] args) {
        // int arr[]={3,6,2,1,8,7,4,5,3,1};
        // // bubbleSort(arr);
        // // insertionSort(arr);
        // countingSort(arr);
        // for(int i= 0;i<arr.length;i++){
        //    System.out.print(arr[i]);
        // }

        System.out.println((int)'V'-(int)'A'-7);
    }
}
