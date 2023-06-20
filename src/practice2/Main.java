package practice2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(cycleArray(new int[]{11, 22, 33, 44, 55}, 2)));
        String str1 = "popka";
        String str2 = str1;

    }

    public static int[] cycleArray(int[] arr, int n) {
        int k = n % arr.length + arr.length;
        for (int i = 0; i < k; i++) {
            int temp = arr[arr.length-1];
            for (int j = arr.length-1; j > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[0] = temp;

        }
        return arr;
    }
}
