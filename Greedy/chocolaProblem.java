package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class chocolaProblem {

    public static void code(){
        int n = 4 , m=6;
        Integer costVer[]={2,1,3,1,4};//m-1
        Integer costHor[]={4,1,2};//n-1

        Arrays.sort(costVer , Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h = 0 , v = 0 ; //these are pointer for the cost arrays
        int hp = 1 , vp =1; //these are trackers for the iterations (pieces)
        int cost = 0;

        //total (n-1)+(m-1) cut are required to seperate chocolate into single pieces
        while(h<costHor.length && v<costVer.length){
            //vertical cost < hor cost   
            if(costVer[v]<=costHor[h]){ //horizontal cut
                cost +=(costHor[h]*vp); //total cost for that cut , as horizontal cut means it goes through all the vertical portions(pieces) seperate or not
                hp++;
                h++;
            }else{//vertical cut
                cost+=(costVer[v]*hp); //similarly
                vp++;
                v++;
            }
        }

        //leftovers

        while(h<costHor.length){
             cost +=(costHor[h]*vp);
                hp++;
                h++;
        }
        while(v<costVer.length){
              cost+=(costVer[v]*hp);
                vp++;
                v++;
        }

        System.out.println("Minimum Cost is "+ cost);
    }
    public static void main(String[] args) {
        code();
    }
}
