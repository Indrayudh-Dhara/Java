package Hashing;

import java.util.HashMap;

public class subArrSumK {
  public static void main(String[] args) {
      HashMap<Integer, Integer> hp = new HashMap<>();
        int arr[] = {10 , 2 , -2 , -20 , 10};
        hp.put(0, 1); //edge case when the entire curr sum is equal to k from start
        int k = -10;
        int ans = 0;
        int sum = 0;
        for(int i = 0 ; i<arr.length ; i++){
            sum+=arr[i];
            if(hp.containsKey(sum-k)){                
                 ans+=hp.get(sum-k);
            }
            if(hp.containsKey(sum)){
                hp.put(sum, hp.get(sum)+1);
            }else{
                hp.put(sum, 1);
            }
            
        }
        System.out.println(ans);
  }  
}
