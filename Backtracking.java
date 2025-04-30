public class Backtracking {

    public static void subsets(String str , String ans,int i){

        //base case
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        

        //yes choice
        subsets(str, ans+str.charAt(i),i+1);
        //no
        subsets(str, ans,i+1);


    }

    public static void permutations(String str , String ans , int i){
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        //a
        permutations(str, ans+str.charAt(i), i+1);
        //b
        permutations(str, ans, i);
        //c
    }

    public static void permutations(String str , String ans){       //abc input - abc,acb,bac,bcb,cab,cba output
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }


        //recursion 
        for(int i = 0; i< str.length();i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0, i)+str.substring(i+1);

            permutations(newStr, ans+curr);  //original str is not changed but its recursion this newstr acts as str for each of the recursive callse
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        // subsets(str,  "",0);
        permutations(str, "");
    }
    
}
