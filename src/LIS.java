public class LIS {

    public static int lisLength(int[] arr){
        int n = arr.length;
        int[] help = new int[n];
        help[0]=arr[0];
        int lis=1;
        int index=0;
        for (int i = 1; i <n ; i++) {
            index=binarySearch(arr,arr[i],lis);
            help[index]=arr[i];
            if(index>lis) lis++;
        }

        return lis;
    }

    public static int binarySearch(int[] arr, int a, int lis){
        if(a<arr[0]) return 0;
        if(a>arr[lis]) return lis+1;
        int start =0;

        while(start<=lis) {
            int mid = (start + lis) / 2;
            if (start == lis) return start;
            else {
                if (a == arr[mid]) {
                    return mid;
                }
                if (a > arr[mid]) {
                    start = mid + 1;
                }
                if (a < arr[mid]) {
                    lis = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,40,0,5,8,1};
        int x = lisLength(arr);
        System.out.println(x);
    }
}
