import java.util.*;

public class Array {

    // linear search:
    public static void linear(int array[], int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                System.out.println("The element is found at position : " + (i + 1));
            }
        }

    }

    // maximum and minimum:
    public static int maxvalue(int array[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Binary search:
    public static void Binary(int array[], int key) {
        int first = 0;
        int last = array.length - 1;
        int mid = 0;
        int flag = 0;
        while (first <= last) {
            mid = (first + last) / 2;
            if (array[mid] == key) {
                System.out.println("The element is found ");
                flag = 1;
                break;
            } else if (array[mid] < key) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        if (flag == 0) {
            System.out.println("There is no element in the array");
        }
    }

    // reverse number:(using binary search type )
    public static void reverse(int array[]) {
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            int temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            first++;
            last--;
        }
    }

    // pairs of array:
    public static void pairsofnumbers(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            for (int j = i + 1; j < array.length; j++) {
                System.out.print("(" + curr + "," + array[j] + ")");
            }
            System.out.println();
        }

    }

    // print sub array + how many count + sum of total sub array :
    public static void subarray(int array[]) {
        int total = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                for (int k = start; k < end; k++) {
                    System.out.print(array[k] + " ");
                    sum = sum + array[k];
                }
                total++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("The total subarray is : " + total);
        System.out.println("The total sum of the sun array is : " + sum);
    }

    // every sum of each sub array :
    public static void everysum(int array[]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                sum = 0;
                for (int k = start; k <= end; k++) {
                    System.out.print(array[k] + " ");
                    sum = sum + array[k];
                }
                System.out.println("The sum of the sub array is : " + sum);
                System.out.println();
            }
            System.out.println();
        }

    }

    // maximum sub array sum :(brute force)

    public static void maximumsubarraysum(int array[]) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                max = 0;
                sum = 0;
                for (int k = start; k <= end; k++) {
                    System.out.print(array[k] + " ");
                    sum = sum + array[k];
                }
                System.out.println("The sum of the sub array is : " + sum);
                if (max < sum) {
                    max = sum;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("The maximum sub of the array is : " + max);
    }

    // maximum sum usig prefix sum style :
    public static void prefix(int array[]) {

        // prifix array creat plus initialize:
        int prefix[] = new int[array.length];
        prefix[0] = array[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }

        // prefixsum declear :
        int prefixsum = 0;
        int max = Integer.MIN_VALUE;

        // as like sub array we get the start and finish element and then use the main
        // condition for this maxisum subarray part using prefix array;

        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                prefixsum = 0;
                if (start == 0) {
                    prefixsum = prefix[end];
                } else {
                    prefixsum = prefix[end] - prefix[start - 1];
                }
                if (max < prefixsum) {
                    max = prefixsum;
                }

            }
        }
        System.out.println("The maximum value of the sun array is : " + max);
    }

    // maximum sum using kandane's rulles:where negative value is 0;
    public static void kandanes(int array[]) {
        int mx = Integer.MIN_VALUE;
        int currentsum = 0;
        for (int i = 0; i < array.length; i++) {
            currentsum = currentsum + array[i];
            if (currentsum < 0) {
                currentsum = 0;
            }
            mx = Math.max(currentsum, mx);
        }
        System.out.println("The maximum sum of the arry is : " + mx);
    }

    public static void main(String args[]) {
        int array[] = { 1, -2, 6, -1, 3 };

        kandanes(array);

        // prefix(array);

        // maximumsubarraysum(array);
        // everysum(array);

        // subarray(array);

        // pairsofnumbers(array);

        /*
         * for (int i = 0; i < array.length; i++) {
         * System.out.print(array[i] + " ");
         * }
         * System.out.print(" The reverse number of the array is : ");
         * reverse(array);
         * for (int i = 0; i < array.length; i++) {
         * System.out.print(array[i] + " ");
         * }
         */

        // linear(array, 4);

        // int maximum = maxvalue(array);
        // System.out.println("The maximum element of the array is : " + maximum);

        // Binary(array, 5);

    }
}