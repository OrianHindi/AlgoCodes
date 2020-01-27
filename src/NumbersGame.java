public class NumbersGame {
    public int[][] buildMat(int[] arr ){
        int n = arr.length;
        int[][] Mat = new int[n][n];
        for(int i=0;i<arr.length;i++){
            Mat[i][i]=arr[i];  //fill the
        }
        for (int i = n-2; i >=0 ; i--) {
            for(int j = i+1;j<n;j++){
                Mat[i][j]=Math.max(arr[i]-Mat[][])
            }

        }
        return Mat;
    }
}
