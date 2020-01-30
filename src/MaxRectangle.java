import java.util.Arrays;
import java.util.Stack;

public class MaxRectangle {

    public static int findMaxRectangle(int[][] mat){
        int rows= mat.length;
        int cols = mat[0].length;
        int maxArea = 0;
        if(cols ==0 || rows ==0) return 0;
        int[] hist = new int[cols];
        for (int i = 0; i <cols ; i++) {
            hist[i]=0;
        }
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(mat[i][j]==1)hist[j]++;
                else hist[j]=0;
            }
            int area =getMaxArea(hist);
            if(area>maxArea)maxArea=area;
        }
        return maxArea;
    }

    public static int getMaxArea(int[] hist){
        int len = hist.length;
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        int checkArea=0;
        int i=0;
        int tp =0;
        while(i<len){
            if(st.isEmpty() || hist[st.peek()] <=hist[i]){
                st.push(i);
                i++;
            }
            else{
                tp=st.pop();
                checkArea = hist[tp]*(st.isEmpty()?i:i-1-st.peek());
                if(checkArea>maxArea)maxArea=checkArea;
            }
        }
        while(!st.isEmpty()){
            tp =st.pop();
            checkArea=hist[tp]*(st.isEmpty()?i:i-1-st.peek());
            if(checkArea>maxArea) maxArea=checkArea;
        }
        return maxArea;

    }



    public static void printmat(int[][] mat){
        for (int i = 0; i <mat.length ; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }


    public static void main(String[] args) {
        int[][] mat= new int[5][5];
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
                mat[i][j]=(int)(Math.random()+0.6);
            }
        }
        printmat(mat);
        int x = findMaxRectangle(mat);
        System.out.println("max area is:" + x);

    }
}
