public class JavaBasics{

    public static void buyAndSellStocks(int arr[]){
        int minBuy=Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length ;i++){
            if(arr[i]<minBuy){
                minBuy=arr[i];
            
            }
            int profit = arr[i]-minBuy;
            if(profit>maxProfit){
                maxProfit=profit;
                
                
            }
        }
        System.out.println(maxProfit);
    }
    public static void pattern(int total){
        
        
        for(int i = 0 ; i<total/2;i++){
            //first half
            int count=1;
            for(int j = 0 ;j<i+1;j++){ 
                System.out.print(count);
                count++;
            }
            //spaces
            for(int j = 0 ; j<total-1-2*i;j++){
                System.out.print(" ");
            }
            //second half
            for(int j = 0 ; j<i+1;j++){ 
                count--;
                System.out.print(count);
            }
            
            System.out.println();
        }
        for(int i = total/2 ; i>0;i--){
            //first half
            int count=1;
            for(int j = 0 ;j<i+1;j++){ 
                System.out.print(count);
                count++;
            }
            //spaces
            for(int j = 0 ; j<total-1-2*i;j++){
                System.out.print(" ");
            }
            //second half
            for(int j = 0 ; j<i+1;j++){ 
                count--;
                System.out.print(count);
            }
            
            System.out.println();
        }
    }
    public static int rotatedArrSearch(int arr[],int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]==target){
                return mid;
            }
            //left sorted 

            if(arr[left]<arr[mid]){
                if(arr[left]<=target && target<=arr[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                //right sorted
                if(arr[mid]<=target && target<=arr[right]){
                    left=mid+1;
                }else{
                    left=mid-1;
                }
            }
        }
        return -1;      
    }

    public static void trappedRainwater(int height[]){
        //left max
           int leftmax[]=new int[height.length];
           leftmax[0]=height[0];
           for(int i = 1; i<height.length;i++){
            leftmax[i] = Math.max(height[i], leftmax[i-1]);
           }
        //    for(int i = 0 ; i<height.length;i++){
        //     System.out.print(leftmax[i]);
        //    }
        //    System.out.println();
           //right max
           int rightmax[]=new int[height.length];
           rightmax[height.length-1]=height[height.length-1];
           for(int i=height.length-2;i>=0;i--){
            rightmax[i]=Math.max(height[i], rightmax[i+1]);
           }

        //    for(int i = 0 ;i<height.length;i++){
        //     System.out.print(rightmax[i]);
        //    }
           int trappedRainwater=0;
           for(int i =0;i<height.length;i++){
             trappedRainwater += Math.min(leftmax[i], rightmax[i])-height[i];
           }
           System.out.println(trappedRainwater);
    }
    public static void main(String[] args) {
    //     int arr[]={4,5,6,7,0,1,2};
    //    System.out.println(rotatedArrSearch(arr, 1)); 
            int height[]={0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
    //    pattern(10);
            trappedRainwater(height);
    }
}