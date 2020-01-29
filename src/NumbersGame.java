public class NumbersGame {
    public static int[][] buildMat(int[] arr ){
        int n = arr.length;
        int[][] Mat = new int[n][n];
        for(int i=0;i<arr.length;i++){
            Mat[i][i]=arr[i];  //fill the slant with the arr values.
        }
        for (int i = n-2; i >=0 ; i--) {
            for(int j = i+1;j<n;j++){
                Mat[i][j]=Math.max(arr[i]-Mat[i+1][j],arr[j]-Mat[i][j-1]); // fill all the Mat with values.
            }

        }
        return Mat;
    }

    public static void gameMoves(int[] arr ){
        int i =0;
        int n = arr.length;
        int j = n-1;
        boolean firstTurn = true;
        int firstSum=0,secondSum=0;
        int[][] Mat = buildMat(arr);
        for (int k = 0; k <n ; k++) {
            for (int l = 0; l <n ; l++) {

                System.out.print(Mat[k][l] + ", ");
            }
            System.out.println();
        }

       while(i<=j) {
            if(firstTurn){
                if(arr[i]-Mat[i+1][j]>arr[j]-Mat[i][j-1]){
                    firstSum+=arr[i];
                    System.out.println("Player A took:" + arr[i] + "    At index:" + i);
                    i++;
                    firstTurn=false;
                }
                else{
                    firstSum+=arr[j];
                    System.out.println("Player A took:" + arr[j] + "    At index:" + j);
                    j--;
                    firstTurn=false;
                }
            }
            else{
                if(arr[i]-Mat[i+1][j]>arr[j]-Mat[i][j-1]){
                    secondSum+=arr[i];
                    System.out.println("Player B took:" + arr[i] + "    At index :" + i);
                    i++;
                    firstTurn=true;
                }
                else{
                    secondSum+=arr[j];
                    System.out.println("Player B took : " + arr[j] + "  At index:" + j);
                    j--;
                    firstTurn=true;
                }
            }


        }

        System.out.println("Player A sum is:" + firstSum);
        System.out.println("Player B sum is:" + secondSum);
    }

    public static void main(String[] args) {
        int[] arr = {10,2,61,551,10,20,321,200};
        gameMoves(arr);


    }
}
