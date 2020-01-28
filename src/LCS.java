public class LCS {
    /**
     * we need to find the Longest common sequence.
     * We will do it with dynamic programing.
     * O(m*n)+O(m+n)=O(m*n) when m=length of first string,n = length of second string.
     */

    public static int[][] buildMat(String X,String Y){
        int row = X.length()+1;
        int col = Y.length()+1;
        int[][] Mat = new int[row][col];
                //first we will insert 0 to first col and row.

        for (int k = 0; k <row ; k++) {
            Mat[k][0]=0;
        }
        for (int k = 0; k <col ; k++) {
            Mat[0][k]=0;
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j <col ; j++) {
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    Mat[i][j]=Mat[i-1][j-1]+1;
                }
                else{
                    Mat[i][j]= Math.max(Mat[i][j-1],Mat[i-1][j]);
                }
            }
        }
        System.out.println("Longest common sequence is:" + Mat[row-2][col-2]);
        return Mat;
    }

    public static String getLCS(String x,String y){
        int[][] Mat = buildMat(x,y);
        StringBuilder ans = new StringBuilder();
        int size = Mat[Mat.length-1][Mat[0].length-1]-1;
        int i = Mat.length-1;
        int j = Mat[0].length-1;

        while(size>=0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                ans.append(x.charAt(i-1));
                size--;
                j--;
                i--;
            }
            else if(Mat[i][j]==Mat[i][j-1]) j--;
            else i--;

        }
        StringBuilder ans2 = new StringBuilder();
        for (i = 0; i <ans.length() ; i++) {
            ans2.append(ans.charAt(ans.length()-1-i));
        }
        return ans2.toString();
    }

    public static void main(String[] args) {
        String X = "antipasti";
        String Y = "anpnasuyft";

        System.out.println(getLCS(X,Y));

    }

}
