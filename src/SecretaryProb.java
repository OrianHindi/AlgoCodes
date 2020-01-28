import java.util.Arrays;

public class SecretaryProb {

    /**
     * in this problem we need get the minimum avg of time the client wait in office.
     * we will sort the array from the lowest time to the biggest time.
     * O(n*logn) to sort the array, +O(n) to sum all the time of each client. =O(nlogn).
     * @param arr the time ea client wait.
     * @return the minimum avg time.
     */
    public static double getAvgTime(int[] arr){
        Arrays.sort(arr);
        double sum =0;
        double avg=0;
        for (int i = 0; i <arr.length ; i++) {
            sum=sum+arr[i];
           avg+=sum;
        }
        return avg/arr.length;
    }

    public static void main(String[] args) {
        int[] time = {3,8,5};
        double x = getAvgTime(time);
        System.out.println(x);
    }
}
