package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class hashmaps{


    static class Hashmaps<K,V>{  //generic type
        private class Node{
            K key;
            V value;

            public Node(K key , V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n; //n
        private int N;
        private LinkedList<Node> buckets[]; //array of linkedlist ,  //N = buckets.length 

        @SuppressWarnings("unchecked") //without this we had to define the type of LL in (this.buckets) and code wouldnt run with a warning
        public Hashmaps(){
            this.N= 4; //no nodes are the beginning
            this.buckets= new LinkedList[4]; //starting off with a ll length 4
            for(int i = 0 ; i<buckets.length ; i++){
                buckets[i]= new LinkedList<>(); //starting off with a empty ll in every bucket
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();  //can provide ANY number but we need a number from 0 to N(bucket .length)
            return Math.abs(hc)%N;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets= new LinkedList[2*N];
            N=2*N;
            //init
            for(int i  = 0 ; i<N ; i++){
                buckets[i]= new LinkedList<>();
            }

            //transfering the previous nodes into this new HashMap (optimized)
            //for every nodes inside every linkedlist in every buckets we have to run the loop
            for(int i = 0 ; i<oldBuck.length ; i++){
                //this loop runs through every bucket
                LinkedList<Node> ll = oldBuck[i];
                for (Node node : ll) {
                    put(node.key, node.value); // rehashing using new bucket size
                }
            }
        }
        
        private int searchInLL(K key , int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0 ; 
            for(int i =  0 ; i<ll.size() ; i++){
                Node node = ll.get(i);
                if(node.key==key){
                    return di;
                }
                di++;
            }
            return -1;//if the node doesnt exist
        }
 
        public void put(K key , V value){ //O(lambda) -- constant

            int bi = hashFunction(key); //the bucket index for the key
            int di = searchInLL(key , bi); //the data index inside that particular bucket for the key .
            if(di!=-1){
                Node node = buckets[bi].get(di);
                node.value = value; //updation
            }else{
                buckets[bi].add(new Node(key, value));
                n++;//increase no of nodes size

            }

            double lambda =(double) n/N;
            if(lambda>=2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di!=-1){
                return true;
            }
            return false;
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di!=-1){
                return buckets[bi].get(di).value;
            }
            return null ;
            
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di!=-1){
                Node node = buckets[bi].remove(di);
                n--;
               return node.value;
            }
            return null;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0 ; i<buckets.length ; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

    }
    public static void main(String[] args) {
        Hashmaps<String , Integer> hm = new Hashmaps<>();
        hm.put("India", 120);
        hm.put("China", 200);
        hm.put("Indonesia", 45);
        hm.put("USA", 80);

        ArrayList<String> keys = hm.keySet();
        System.out.println(keys);
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }

}