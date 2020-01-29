import java.util.Arrays;

public class GlassBalls {
    /**
     * we will do 2 problems.
     * first problem with k balls and n floors.
     * second problem with 2 balls and n floors.
     * first problem time complexity:O(n*k)
     * second problem time complexity: O(square n) better time complexity is square of 2n.
     */


    public static int kBallProb(int balls,int floors){
        int [][] temp = new int[balls +1][floors+1];
        for (int i = 1; i <balls+1 ; i++) { // for 0 or 1 balls.
            temp[i][0]=0;
            temp[i][1]=1;
        }
        for (int i = 1; i <floors+1 ; i++) {
            temp[1][i]=i;
        }
        for (int i = 2; i <temp.length ; i++) {
            for (int j = 2; j <temp[0].length ; j++) {
                temp[i][j]=Integer.MAX_VALUE;
                for (int k = 1; k <=j ; k++) {
                    int res = Math.max(temp[i-1][k-1],temp[i][j-k])+1;
                    if(temp[i][j]>res){
                        temp[i][j]=res;
                    }

                }
            }
        }
        return temp[balls][floors];
    }


    public static int[][] buildMat(int balls,int floors){
        int [][] temp = new int[balls +1][floors+1];
        for (int i = 1; i <balls+1 ; i++) { // for 0 or 1 balls.
            temp[i][0]=0;
            temp[i][1]=1;
        }
        for (int i = 1; i <floors+1 ; i++) {
            temp[1][i]=i;
        }
        for (int i = 2; i <temp.length ; i++) {
            for (int j = 2; j <temp[0].length ; j++) {
                temp[i][j]=Integer.MAX_VALUE;
                for (int k = 1; k <=j ; k++) {
                    int res = Math.max(temp[i-1][k-1],temp[i][j-k])+1;
                    if(temp[i][j]>res){
                        temp[i][j]=res;
                    }

                }
            }
        }
        return temp;
    }


    public static int findfirstfloor(int[] arr,int ballpower,int balls){
        int[][] mat= buildMat(balls,arr.length);
        int checks =mat[balls][arr.length];
        System.out.println(checks);
        int[][] help = new int[balls][mat[balls][arr.length]];
        int max=0;
        for (int i = 1; i <= balls; i++) {
            int col=0;
            for (int j = 1; j < arr.length ; j++) {
                max=mat[i][j];
                if(max!=mat[i][j+1]){
                    help[i-1][col++]=j;
                    if(col==5) break;
                }

            }
            System.out.println(Arrays.toString(help[i-1]));
        }
    return 0;
    }





    public static int kBallRec(int balls,int floors){
        if(floors==0 || floors==1) return floors;
        if(balls==1) return floors;
        int min = Integer.MAX_VALUE;
        int res;
        int x;
        for(x=1;x<=floors;x++){
            res=Math.max(kBallRec(balls,floors-x),kBallRec(balls-1,x-1));
            if(min>res) min=res;
        }
        return min;
    }
    static int eggDrop(int n, int k)
    {
        // If there are no floors, then
        // no trials needed. OR if there
        // is one floor, one trial needed.
        if (k == 1 || k == 0)
            return k;

        // We need k trials for one egg
        // and k floors
        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE;
        int x, res;

        // Consider all droppings from
        //1st floor to kth floor and
        // return the minimum of these
        // values plus 1.
        for (x = 1; x <= k; x++)
        {
            res = Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }
    public static void main(String[] args) {
        int[] arr = new int[23];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        int x = findfirstfloor(arr,20,3);
        System.out.println("floor is :" + x);
    }
}
