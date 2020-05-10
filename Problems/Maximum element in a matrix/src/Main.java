import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[scanner.nextInt()][scanner.nextInt()];
        int maxValue = Integer.MIN_VALUE;
        int maxLine = 0;
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                    maxLine = i;
                    maxIndex = j;
                }
            }
        }

        System.out.printf("%d %d", maxLine, maxIndex);
    }
}