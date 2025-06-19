package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapSack {
    //we can include fractional item but not multiple (ie more than the weight given for an item)

    public static void knapSackFractional(int value[] , int weight[] , int w){

        //we need the highest value and least weight , thus we need higher value to weight ratio (sorted in descending order).

        double ratio[][]= new double[value.length][2]; //one for index another for ratio , double as ratio can be decimal and we need it

        for(int i  = 0  ; i<ratio.length ; i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i]; //cuz we dont want them to get normalised into a integer

        }

        Arrays.sort(ratio, Comparator.comparingDouble((double[] o) -> o[1]).reversed()); //for descending order , or we can just start the loop of calculation of Knapscak from the end
    
        //here the ratios are sorted in descending order 

        int capacity = w;
        int valueT=0;
        for(int i = 0 ; i<ratio.length ; i++){
            int idx = (int)ratio[i][0];
            if(capacity>=weight[idx]){ //include full item
                valueT+=value[idx];
                capacity-=weight[idx];
            }else{
                //include fractional
                valueT+=capacity*ratio[i][1];
                capacity=0;
                break;
            }
        }
        System.out.println("final Max Value - "+valueT);
    }
    public static void main(String[] args) {
        int value[]= {60 , 100 , 120};
        int weight[] = {10,20,30};
        knapSackFractional(value, weight, 50);
    }
}
