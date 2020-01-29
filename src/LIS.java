public class LIS {

//    public static int lisLength(int[] arr){
//        int n = arr.length;
//        int[] help = new int[n];
//        help[0]=arr[0];
//        int lis=1;
//        int index=0;
//        for (int i = 1; i <n ; i++) {
//            index=binarySearch(arr,arr[i],lis);
//            help[index]=arr[i];
//            if(index>lis) lis++;
//        }
//
//        return lis;
//    }

    public static int binarySearch(int[][] arr, int lis, int a){
        if(a<arr[0][0]) return 0;
        if(a>arr[lis-1][lis-1]) return lis;
        int start =0;
        lis--;

        while(start<=lis) {
            int mid = (start + lis)/ 2;
            if (start == lis) return start;
            else {
                if (a<arr[mid+1][mid+1] && a>arr[mid][mid]) {
                    return mid+1;
                }
                if (a >arr[mid][mid]) {
                    start = mid + 1;
                }
                if (a < arr[mid][mid]) {
                    lis = mid;
                }
            }
        }
        return -1;
    }
    public static int[] longestIS(int[] arr) {
        int n = arr.length;
        int[][] help = new int[n][n];
        help[0][0] = arr[0];
        int lis = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearch(help, lis, arr[i]);
            for (int j = 0; j < index; j++) {
                help[index][j] = help[index - 1][j];
            }
            help[index][index] = arr[i];
            if (index >= lis) lis++;
        }
        int[] ans = new int[lis];

        for (int i = 0; i <lis ; i++) {
        ans[i]=help[lis-1][i];
    }
        return ans;
}

    public static void main(String[] args) {
        int[] arr = {8,4,12,2,14,10,3,5,6,7};
        int[] ans = longestIS(arr);
        for (int i = 0; i <ans.length ; i++) {
            System.out.print(ans[i] + ",");
        }
    }
}
