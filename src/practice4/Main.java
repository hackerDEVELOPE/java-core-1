package practice4;

public class Main {
    public static void main(String[] args) {
        System.out.println(squareSum(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
    public static int squareSum(int[] n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i] * n[i];

        }
        return sum;
    }
}
