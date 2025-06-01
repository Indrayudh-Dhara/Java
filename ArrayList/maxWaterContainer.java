package ArrayList;

import java.util.ArrayList;

public class maxWaterContainer {

    //brute force
    //O(n^2)
    public static int waterVolume(ArrayList<Integer> height, int edge1 , int edge2){
        int n = Math.min(height.get(edge1) , height.get(edge2));
        int volume = n * (edge2-edge1);
        return volume;
    }

    public static void waterContainer(ArrayList<Integer> height ){
        int maxVolume = Integer.MIN_VALUE;
        for(int i = 0 ; i<height.size(); i++){
            for(int j = i  ; j<height.size() ; j++){
               int volume =  waterVolume(height,i , j);
               if(volume>=maxVolume){
                maxVolume=volume;
               }
            }
        }
        System.out.println(maxVolume);

    }

    //O(n)
    public static void optimizedWaterContainer(ArrayList<Integer> height){
        int maxVolume = Integer.MIN_VALUE;
        int i = 0;
        int j = height.size()-1;
        while(i<j){
            int volume = waterVolume(height, i, j);
            if(volume>maxVolume){
                maxVolume=volume;
            }
            if(height.get(i)>=height.get(j)){
                j--;
            }else{
                i++;
            }

        }
        System.out.println(maxVolume);
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        
        waterContainer(height);
    }
}
