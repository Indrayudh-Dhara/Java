import java.util.Stack;

public class maxAreaHistogram {
    public static void maxArea(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int currHeight = arr[i];  // virtual zero at end

            while (!stack.isEmpty() && currHeight < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        System.out.println("Maximum Area: " + maxArea);
    }

    //mentor
    public static void maxAreaMentor(int histogram[]){
        int maxArea=0;
        int nsr[] = new int[histogram.length]; // to store the indexes of the next smaller right element of every bar for histogram
        int nsl[]= new int[histogram.length]; //similarly for the left
        //next Smaller Right
        Stack<Integer> s = new Stack<>();
        for(int i = histogram.length -1; i>=0 ; i--){
            // we want smaller element than current histogram bar , hence remove the biggers
            while(!s.isEmpty() && histogram[s.peek()]>=histogram[i]){
                s.pop();
            }
            //here the stack top is smaller than the current element or the stack is empty
            if(s.isEmpty()){
                nsr[i]=histogram.length; //as nothing smaller means the current element goes till the end of the histogram and includes all (think about it)
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);

        }
        //next Smaller Left
        s = new Stack<>(); //emptying the stack for the nsl calculation
        for(int i = 0 ; i<histogram.length ; i++){
            // we want smaller element than current histogram bar , hence remove the biggers
            while(!s.isEmpty() && histogram[s.peek()]>=histogram[i]){
                s.pop();
            }
            //here the stack top is smaller than the current element or the stack is empty
            if(s.isEmpty()){
                nsl[i]=-1; //as nothing smaller means the current element goes till the start of the histogram and includes all (think about it) thus we need one before start which is -1
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);

        }
        //curr Area
        for(int i = 0 ; i<histogram.length ; i++){
            int height=histogram[i];
            int width = nsr[i]-nsl[i]-1;
            int area = height*width;
            maxArea=Math.max(maxArea, area);

        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};
        maxAreaMentor(arr);
    }
}
