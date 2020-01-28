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
        for (int i = 1; i <balls+1 ; i++) {
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

    public static void main(String[] args) {
        int x = kBallProb(3,22);
        System.out.println(x);
    }
}
