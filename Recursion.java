public class Recursion {

    public static void printDecreasing(int n){
        System.out.println(n);
        if(n==1){
            return;
        };
        printDecreasing(n-1);
    };

    public static void printIncreasing(int n){
        if(n==1){
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }
    public static int factorial(int n){
        if(n==0){
            return 1 ;
        }
        int f = n*factorial(n-1);
        return f;
    }

    public static int sumNatural(int n){
        if(n==1){
            return 1;
        }
        int sum = n + sumNatural(n-1);
        return sum;
    }

    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fibo = fibonacci(n-1)+fibonacci(n-2);
        return fibo;
    }

    public static boolean sortedRecursive(int arr[] ,int i){
        //if we reach the last element it means the array is sorted
        if (i==arr.length-1) {
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
//         The recursive function would still run, but its result wouldn't be used if we wrote is as 
//         sortedRecursive(arr, i + 1); // ❌ Wrong!
//         return true;  // ❌ Always returns true

// ✅ Using return ensures the final result is passed back up the recursion chain.
// ✅ Each recursive call must return the correct boolean value to maintain correctness.

        return sortedRecursive(arr, i+1);
        
    }

    public static int firstOccurence(int arr[],int key,int i){
        //first compare
        if (i==arr.length-1) {
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        //then search forward
        return firstOccurence(arr, key, i+1);

    }

    public static int lastOccurenceV2(int arr[],int key,int i){
        //base case
        if (i==arr.length) {    
            return -1;
        }
        //first search forward
        int isFound = lastOccurenceV2(arr, key, i+1);
        if(isFound==-1 && arr[i]==key ){
            return i;
        }

        return isFound;

            //PROPAGATION LOGIC
            // // int isFound = lastOccurenceV2(arr, 2, 6);  // Returns -1
            // int isFound = lastOccurenceV2(arr, 2, 5);  // Returns 5
            // int isFound = lastOccurenceV2(arr, 2, 4);  // Returns 5
            // int isFound = lastOccurenceV2(arr, 2, 3);  // Returns 5
            // int isFound = lastOccurenceV2(arr, 2, 2);  // Returns 5
            // int isFound = lastOccurenceV2(arr, 2, 1);  // Returns 5
            // int isFound = lastOccurenceV2(arr, 2, 0);  // Returns 5


    }

    public static int powerFunct(int x, int n){
        //base case
        if(n==0){
            return 1;
        }
        //recursive call
        return x*powerFunct(x, n-1);
        
    }

    public static int optimizedPower(int x , int n){
        //base case
        if(n==0){
            return 1;
        }
        int halfpower = optimizedPower(x, n/2);
        int halfpowerSq = halfpower*halfpower;
        if(n%2!=0){
            halfpowerSq=x*halfpowerSq;
        }
        return halfpowerSq;
    }

    public static int lastOccurence(int arr[],int key,int i){
        if (i==0) {
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return lastOccurence(arr, key, i-1);

    }

    public static int tilingProblem(int n){
        //base case
        if(n==1 || n==0){
            return 1;
        }

        //vertical choice
        int fnm1= tilingProblem(n-1);
    
        //horizontal choice
        int fnm2 = tilingProblem(n-2);

        //total ways
        return fnm1+fnm2;

    }

    public static void removeDuplicates(String str, int idx , StringBuilder newStr , boolean map[]){
        //base case
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']== true){
            removeDuplicates(str, idx+1, newStr, map);
        }else{
            map[currChar-'a']=true;
            removeDuplicates(str, idx, newStr.append(currChar), map);
        };
    };

    public static int friendPairingProblem(int n){
        //base case
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        //single
        int single = friendPairingProblem(n-1);

        //paired
        int paired = (n-1)*friendPairingProblem(n-2);

        //total ways
        return single+paired;
    }

    public static void binaryStringProblem(int n , int lastindex , String str){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }
        binaryStringProblem(n-1, 0, str+"0");
        if(lastindex==0){ 
            binaryStringProblem(n-1, 1, str+"1");
        }
    }

    public static void occurenceProblem(int arr[],int key,int idx){
        //base case
        if(idx==arr.length){
            return;
        }
        //kaam   
        if(arr[idx]==key){
            System.out.print(idx);
        }
        occurenceProblem(arr, key, idx+1);

    }

    public static void numToString(int number , String map[]){
        //base case
        if(number==0){
            return;
        }
        //kaam
        int lastDigit = number%10;
        numToString(number/10, map);
        System.out.print(map[lastDigit]);
        

    }

    public static void stringLength(String str , int count){
        //base case
        if(count==str.length()){
            System.out.println(count);
            return;
        }
        //kaam
        if(str.charAt(count)!=0){
            stringLength(str, count+1);
        }
    }

    //OR

    public static int length(String str) {
        // Base Case
        if (str.length() == 0) {
            return 0;
        }
        // Recursive Case
        return length(str.substring(1)) + 1; //REMOVES THE FIRST LETTER FROM STR & CALCULATES LENGTH ON THE REMAINING STR
    }    
    static int count=0;
    public static int continguosSubstr(String str,int si, int ei){
        //base case
        if(si>ei){
           return count;
        }
        //kaam
        //si increase
            if(str.charAt(si)==str.charAt(ei)){
                count++;
            }
            count=count-2;
            return continguosSubstr(str, si+1, ei)+continguosSubstr(str, si, ei-1)-continguosSubstr(str, si+1, ei-1);
            
    }


    public static void main(String[] args) {
        String str = "abcab";
        System.out.println(continguosSubstr(str, 0, str.length()-1));
    };
    
};
