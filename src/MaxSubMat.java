public class MaxSubMat {

    public static int findSubMat(int[][] mat){
        int maxDim=0;
        int n = mat.length;
        int[][] help = new int[n][n];

        for (int i = 0; i <n ; i++) {
            help[0][i]=mat[0][i];   //fill first row with values from original mat.
            help[i][0]=mat[i][0];   //fill first col with values from original mat.
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <n ; j++) {
                if(mat[i][j]==1){
                    help[i][j]= findMin(help[i-1][j-1],help[i-1][j],help[i][j-1])+1;
                    if(help[i][j]>maxDim) maxDim=help[i][j];
                }
            }
        }
        return maxDim;
    }
    public static int countsubMat(int[][] mat,int size){
        int n = mat.length;
        int[][] help = new int[n][n];

        for (int i = 0; i <n ; i++) {
            help[0][i]=mat[0][i];   //fill first row with values from original mat.
            help[i][0]=mat[i][0];   //fill first col with values from original mat.
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <n ; j++) {
                if(mat[i][j]==1){
                    help[i][j]= findMin(help[i-1][j-1],help[i-1][j],help[i][j-1])+1;
                }
            }
        }
        int counter=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(help[i][j]>=size)counter++;
            }
        }
        return counter;
    }

    public static int findMin(int a,int b,int c){
        int min = a;
        if(b<min)min=b;
        if(c<min) min=c;

        return min;
    }

    public static void main(String[] args) {
        int[][] temp = {{0,1,1,0,0},{0,0,1,0,0},{0,0,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int x = countsubMat(temp,2);
        System.out.println(x);
    }
}
