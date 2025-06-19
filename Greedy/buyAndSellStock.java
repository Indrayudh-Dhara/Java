package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class buyAndSellStock {

    //my code -> works but risky i guess according to the internet
    public static int code(int stock[]){
        int arr[][] = new int[stock.length][2];
        for( int i = 0 ; i<arr.length ; i++){
            arr[i][0]=i; //these are the days 
            arr[i][1]=stock[i];//these are the values of stocks
        }

        // we wanna sort the values in ascending as we want the stock price to be as low as possible while buying

        Arrays.sort(arr,Comparator.comparingDouble(o -> o[1]));

        int boughtdate = arr[0][0]; // we selected the day with least stock price;
        
        for(int i = arr.length-1 ; i>=0 ; i--){
            if(arr[i][0]>boughtdate){
                return  (arr[i][1]-arr[0][1]) ;
            }
        }

        return 0;
    }

    public static int codeV2(int stock[]){
        int buy = stock[0] ; //hard coded
        int maxProfit =0 ; //initialization
        for(int i =1 ; i<stock.length ; i++){
            if(stock[i]<buy){
                //update buy as we want the lowest buying value ever
                buy = stock[i];
            }else if(stock[i]-buy >=maxProfit){//else if thus stock price is greater than buy price , thus we check for profit and selling
                maxProfit=stock[i]-buy;

            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int stock[]= {7,1,5,6,3};
        System.out.println(codeV2(stock));
    }
}
