public class MedianProb {
    /**
     * we have 2 problem.
     * first problem: unsorted array of ransom numbers the number that is bigger from the median.
     * second problem: 2 sorted array at same size, find the numbers that are bigger then the median.
     * first problem: O(1)
     * second problem: O(n)
     */


    /**
     * we can check only the first 64 numbers.when we get the maximum of them we can return it because 100% bigger then median if the array isnot sorted/
     * @param arr the unsorted array
     * @return num bigger then median
     */
    public static int firstMedian(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length - 1 && i < 63; i = i + 2) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) max = arr[i];
            } else {
                if (arr[i + 1] > max) max = arr[i + 1];
            }
        }
        return max;
    }

    public static int[] secondMedian(int[] arr, int[] arr2) {
        if(arr[0]>arr2[arr.length-1]) return arr;
        int[] ans = new int[arr.length];
        int j = arr.length - 1;
        int size = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            arr[size--]=Math.max(arr[i],arr2[j-i]);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temp = {1,2,3,4,5,6,7,8};
        int[] temp2 = {9,10,11,12,13,14,15,16};

        int[] temp3= secondMedian(temp,temp2);

        for (int i = 0; i <temp3.length ; i++) {
            System.out.print(temp3[i] + ",");
        }

    }
}
