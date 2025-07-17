package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findItenary {

    public static void itinerary(HashMap<String , String> routes){
        ArrayList<String> iternary = new ArrayList<>();//to store the actual correct route

        Set<String> pickups = routes.keySet();//to store all the pickup locations (keys)
        

        Set<String> drops = new HashSet<>();//to store all the dropoff locations (values)

        for(String pickup : pickups){
            drops.add(routes.get(pickup));
        }
        String start = "";//to store the start (the one which isnt in the dropoff)
        
        for(String pickup : pickups){
            if(!drops.contains(pickup)){
                start = pickup;
            }
        }
        iternary.add(start); //starting off with the start

        int count = drops.size(); 

        for(int i = 0 ; i<count ; i++){
            String drop = routes.get(iternary.get(i));
            iternary.add(drop);
        }
        //print iternary
        for(int i = 0 ; i<iternary.size() ; i++){
            if(i==iternary.size()-1){
                System.out.print(iternary.get(i));
            }else{
                System.out.print(iternary.get(i)+ " -> ");
            }
            
        }
    }

    //another approach of using a reverseMap for the routes can be used
    
   public static void main(String[] args) {
    HashMap<String , String> routes = new HashMap<>();
    routes.put("Chennai", "Bengaluru");
    routes.put( "Mumbai", "Delhi");
    routes.put("Goa", "Chennai");
    routes.put("Delhi" , "Goa");
    itinerary(routes);
   }
}
